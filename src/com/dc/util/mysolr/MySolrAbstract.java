package com.dc.util.mysolr;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.FieldStatsInfo;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;

import com.dc.util.mysolr.bean.SolrResult;
import com.dc.util.mysolr.config.ConfigFactory;
import com.dc.util.mysolr.config.ConfigFactoryImpl;
import com.dc.util.mysolr.config.bean.query.FacetField;
import com.dc.util.mysolr.config.bean.query.Facets;
import com.dc.util.mysolr.config.bean.query.Fusions;
import com.dc.util.mysolr.config.bean.query.Mapper;
import com.dc.util.mysolr.config.bean.query.Set;
import com.dc.util.mysolr.config.bean.query.Sort;
import com.dc.util.mysolr.config.bean.query.types.TypeType;
import com.dc.util.mysolr.wrapper.DefaultWrapper;
import com.dc.util.mysolr.wrapper.Wrapper;

public abstract class MySolrAbstract implements MySolr {

	protected static final Logger logger = Logger.getLogger(MySolrAbstract.class);

	protected static final VelocityEngine VELOCITY_ENGINE = new VelocityEngine();

	protected static final int SIZE = 64;

	protected static final String FILE = "mysolr/solrQueryConfig.xml";

	private static final String SPATIAL_SET = "spatial";

	protected SolrServer solrServer;

	protected Map<String, Mapper> config;

	private static final String MAX_FUN_NAME = "max";
	private static final String MIN_FUN_NAME = "min";

	public MySolrAbstract() {

		this.config = createConfig(FILE);
	}

	public MySolrAbstract(String configFile) {

		this.config = createConfig(configFile);
	}

	public SolrServer getSolrServer() {

		return this.solrServer;
	}

	public void setSolrServer(SolrServer solrServer) {
		this.solrServer = solrServer;
	}

	protected Map<String, Mapper> createConfig(String file) {

		ConfigFactory configFactory = new ConfigFactoryImpl();

		try {
			return configFactory.getConfig(file);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
		return null;
	}

	protected SolrQuery getQuery(Map<String, Object> model, Mapper mapper) {

		Context context = new VelocityContext();

		if (model != null && model.size() > 0) {

			for (Entry<String, Object> entry : model.entrySet()) {

				String key = entry.getKey();
				Object value = entry.getValue();

				if (value != null && value instanceof java.lang.String) {

					value = ClientUtils.escapeQueryChars(value.toString());
				}

				context.put(key, value);
			}
		}

		SolrQuery solrQuery = new SolrQuery();

		String query = mapper.getQuery();
		query = query.replaceAll("\n", "").replaceAll("\t", " ");

		String[] fqs = mapper.getFilterQuery();
		Set[] sets = mapper.getSet();
		String fields = mapper.getFields();
		Sort[] sorts = mapper.getSort();

		// 分组
		Facets facets = mapper.getFacets();

		StringWriter writer = new StringWriter();

		VELOCITY_ENGINE.evaluate(context, writer, "", query);
		query = writer.toString();

		logger.debug("query:" + query);

		solrQuery.setQuery(query);

		if (fqs != null && fqs.length > 0) {

			for (String fq : fqs) {

				writer = new StringWriter();
				VELOCITY_ENGINE.evaluate(context, writer, "", fq);
				fq = writer.toString();

				logger.debug("add fq:" + fq);
				solrQuery.addFilterQuery(fq);
			}
		}

		if (sets != null && sets.length > 0) {

			for (Set set : sets) {

				String key = set.getKey();
				String value = set.getValue();

				if (set.hasIsTrue()) {

					boolean isTrue = set.getIsTrue();

					if (SPATIAL_SET.equals(key) && isTrue) {

						this.addPtSet(solrQuery, model);
					}
					logger.debug("set " + key + " : " + isTrue);
					solrQuery.set(key, isTrue);

					continue;
				} else {

					logger.debug("set " + key + " : " + value);
					solrQuery.set(key, value);
				}
			}
		}

		if (fields != null && !fields.trim().equals("")) {

			logger.debug("fields:" + fields);
			solrQuery.setFields(fields);
		}

		for (Sort sort : sorts) {
			if (sort != null) {

				ORDER orderType = sort.getType().equals(TypeType.DESC) ? ORDER.desc : ORDER.asc;

				logger.debug("sort:" + sort.getField() + " " + orderType);

				solrQuery.setSort(sort.getField(), orderType);
			}

		}

		if (facets != null) {
			FacetField[] facetFields = facets.getFacetField();

			if (facets.getFusion().equals("false")) { // 只分组
				String[] fileds = new String[facetFields.length];

				for (int i = 0; i < facetFields.length; i++) {
					fileds[i] = facetFields[i].getFacet();
				}

				solrQuery.setFacet(true).addFacetField(fileds).setFacetLimit(facets.getFacetLimit())
						.setFacetMinCount(facets.getFacetMinCount());

			} else if (facets.getFacet().equals("false")) { // 只聚合

				String[] fusionFields = facetFields[0].getFusions().getFusionField();
				for (int i = 0; i < fusionFields.length; i++) {
					String[] str = fusionFields[i].split(":");

					if (str.length == 1) {
						// footTemplate.put(str[0], "sum");
					} else {
						// footTemplate.put(str[0], str[1]);
						fusionFields[i] = str[0];
					}
				}
				solrQuery.setParam("stats", true);
				solrQuery.setParam("stats.field", fusionFields);
				solrQuery.setParam("indent", true);

			} else { // 分组之后聚合
				solrQuery.setParam("stats", true);

				String str = "";
				for (FacetField facetField : facetFields) {
					String facet = facetField.getFacet();
					// f = facet;
					// footTemplate.put(facet, "group");
					String[] fusionField = facetField.getFusions().getFusionField();
					for (int i = 0; i < fusionField.length; i++) {
						String[] strr = fusionField[i].split(":");
						if (strr.length == 1) {
							// footTemplate.put(strr[0], "sum");
						} else {
							// footTemplate.put(strr[0], strr[1]);
							fusionField[i] = strr[0];
						}
						str = str + fusionField[i] + ",";
						fusionField[i] = "f." + fusionField[i] + ".stats.facet";
						solrQuery.setParam(fusionField[i], facet);
					}
				}
				solrQuery.setParam("stats.field", str.split(","));
				solrQuery.setParam("indent", true);

			}

		}

		return solrQuery;

	}

	protected Wrapper getWapper(Mapper mapper) {

		Wrapper wrapper = null;

		String wrapperName = mapper.getWrapper();

		logger.debug("wrapper:" + wrapperName);

		if (wrapperName != null && !wrapperName.trim().equals("")) {

			Object obj = null;

			try {
				Class clazz = Class.forName(wrapperName);
				obj = clazz.newInstance();
			} catch (Exception e) {
				logger.warn(e.getMessage(), e);
			}

			if (obj != null && obj instanceof Wrapper) {

				wrapper = (Wrapper) obj;
			}
		}

		if (wrapper == null) {

			wrapper = new DefaultWrapper();
		}

		return wrapper;

	}

	protected List getResult(SolrDocumentList sdl, Wrapper wrapper) {

		List<Object> result = new ArrayList<Object>(sdl.size());

		for (SolrDocument doc : sdl) {

			Object obj = wrapper.wrapper(doc);

			result.add(obj);
		}

		return result;
	}

	protected List getResult(QueryResponse queryResponse, String resultType, Wrapper wrapper) {

		List beans = null;

		try {
			beans = queryResponse.getBeans(Class.forName(resultType));
		} catch (ClassNotFoundException e) {

			logger.error(e.getMessage(), e);

			throw new RuntimeException(e);
		}

		if (beans == null || beans.size() == 0) {

			return null;
		}

		List<Object> result = new ArrayList<Object>(beans.size());

		for (Object bean : beans) {

			Object obj = wrapper.wrapper(bean);

			result.add(obj);
		}

		return result;
	}

	protected SolrResult getReturn(QueryResponse queryResponse, SolrDocumentList sdl, Wrapper wrapper, Mapper mapper) {

		String resultType = mapper.getResultType();

		long total = sdl.getNumFound();

		logger.debug("resultType: " + resultType);

		List<Object> result = (resultType == null) ? this.getResult(sdl, wrapper)
				: this.getResult(queryResponse, resultType, wrapper);

		SolrResult sr = new SolrResult();

		sr.setCount(total);
		sr.setList(result);

		Map<String, ? extends Object> map = queryResponse.getFieldStatsInfo();

		List<Map<String, Object>> footer = new ArrayList<Map<String, Object>>();

		logger.debug("map:" + map);

		Map<String, Map<String, String>> fusions = new HashMap<String, Map<String, String>>();

		// logger.debug("footTemplate:" + footTemplate);

		int i = -1;

		Facets mapperFacets = mapper.getFacets();

		if (mapperFacets != null) {

			FacetField[] facetFields = mapperFacets.getFacetField();

			if (facetFields != null && facetFields.length != 0) {

				for (FacetField facetField : facetFields) {

					String facet = facetField.getFacet();

					Fusions mapperFusions = facetField.getFusions();

					if (mapperFusions != null) {

						String[] fusionFields = mapperFusions.getFusionField();

						Map<String, String> funsionMap = new HashMap<String, String>();

						for (String fusionField : fusionFields) {

							String[] funsionSplit = fusionField.split(":");

							String columnName = funsionSplit[0];
							String calculation = (funsionSplit.length < 2) ? "sum" : funsionSplit[1].toLowerCase();

							FieldStatsInfo info = (FieldStatsInfo) map.get(columnName);

							String funsionValue = this.getFieldValue(info, calculation);

							funsionMap.put(fusionField, funsionValue);
						}

						fusions.put(facet, funsionMap);
					}
				}
			}
		}

		sr.setFusions(fusions);

		sr.setFooter(footer);

		List<org.apache.solr.client.solrj.response.FacetField> facet = queryResponse.getFacetFields();
		sr.setFacets(facet);

		return sr;
	}

	private void addPtSet(SolrQuery solrQuery, Map<String, Object> map) {

		String lat = map.get(LAT).toString();
		String lng = map.get(LNG).toString();

		StringBuilder sb = new StringBuilder();

		sb.append(lng).append(",").append(lat);

		String pt = sb.toString();

		logger.debug("pt= " + pt);

		solrQuery.set("pt", pt);
	}

	private String getFieldValue(FieldStatsInfo entr, String name) {

		switch (name.toLowerCase()) {
		case MAX_FUN_NAME:
			return entr.getMax().toString();
		case MIN_FUN_NAME:
			return entr.getMin().toString();
		default:

			StringBuilder sb = new StringBuilder("field name:");
			sb.append(entr.getName()).append(" not can't deal Calculation:").append(name);

			String message = sb.toString();

			logger.error(message);

			throw new RuntimeException(message);

		}

	}
}

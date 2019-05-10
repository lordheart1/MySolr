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
import com.dc.util.mysolr.config.bean.query.Mapper;
import com.dc.util.mysolr.config.bean.query.Set;
import com.dc.util.mysolr.config.bean.query.Sort;
import com.dc.util.mysolr.config.bean.query.types.TypeType;
import com.dc.util.mysolr.wrapper.DefaultWrapper;
import com.dc.util.mysolr.wrapper.Wrapper;

public abstract class MySolrAbstract implements MySolr {

	protected static final Logger logger = Logger.getLogger(MySolrAbstract.class);

	protected static final VelocityEngine VELOCITY_ENGINE = new VelocityEngine();

	protected static final int SIZE = Integer.MAX_VALUE;

	protected static final String FILE = "mysolr/solrQueryConfig.xml";

	private static final String SPATIAL_SET = "spatial";

	protected static Map<String, Object> footTemplate = new HashMap<String, Object>();

	protected static String f = null;

	protected SolrServer solrServer;

	protected String solrHost = "http://10.1.1.11:8081/solr/bill";

	protected String solrUrl = "/update?wt=json";

	protected Map<String, Mapper> config;

	public MySolrAbstract() {

		this.config = createConfig(FILE);
	}

	public MySolrAbstract(String configFile) {

		this.config = createConfig(configFile);
	}

	public String getSolrHost() {
		return solrHost;
	}

	public void setSolrHost(String solrHost) {
		this.solrHost = solrHost;
	}

	public SolrServer getSolrServer() {

		if (this.solrServer != null) {

			return this.solrServer;
		}

		synchronized (this.solrHost) {

			this.solrServer = new org.apache.solr.client.solrj.impl.HttpSolrServer(this.solrHost);
		}

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
						footTemplate.put(str[0], "sum");
					} else {
						footTemplate.put(str[0], str[1]);
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
					f = facet;
					footTemplate.put(facet, "group");
					String[] fusionField = facetField.getFusions().getFusionField();
					for (int i = 0; i < fusionField.length; i++) {
						String[] strr = fusionField[i].split(":");
						if (strr.length == 1) {
							footTemplate.put(strr[0], "sum");
						} else {
							footTemplate.put(strr[0], strr[1]);
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

	protected SolrResult getReturn(QueryResponse queryResponse, SolrDocumentList sdl, Wrapper wrapper,
			String resultType) {

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

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		logger.debug("footTemplate:" + footTemplate);

		int i = -1;

		if (map != null && !map.isEmpty()) {
			for (Entry<String, ? extends Object> entry : map.entrySet()) {

				Map<String, Object> m = (Map<String, Object>) entry.getValue();

				Map<String, Object> facets = (Map<String, Object>) m.get("facets");

				if (f == null) { // 聚合
					footTemplate.put(entry.getKey(), m.get(footTemplate.get(entry.getKey())));
					if (i == -1) {
						footer.add(footTemplate);
					}
				} else { // 分组之后聚合
					List<Map<String, Object>> group = (List<Map<String, Object>>) facets.get(f);
					for (Map<String, Object> entr : group) {
						if (i == -1) {
							Map<String, Object> foot = new HashMap<String, Object>();
							foot.put(f, entr.get("name"));
							foot.put(entry.getKey(), entr.get(footTemplate.get(entry.getKey())));
							footer.add(foot);
						} else {
							footer.get(i).put(entry.getKey(), entr.get(footTemplate.get(entry.getKey())));
							i++;
						}
					}
				}
				i = 0;
				list.add(m);
			}
		}

		sr.setFusions(list);

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

	public String getSolrUrl() {
		return solrUrl;
	}

	public void setSolrUrl(String solrUrl) {
		this.solrUrl = solrUrl;
	}

}

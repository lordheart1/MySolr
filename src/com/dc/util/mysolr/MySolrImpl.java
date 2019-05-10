package com.dc.util.mysolr;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;

import com.dc.util.mysolr.bean.SolrResult;
import com.dc.util.mysolr.config.bean.query.Mapper;
import com.dc.util.mysolr.wrapper.Wrapper;

public class MySolrImpl extends MySolrAbstract {
	
	private static final Logger logger = Logger.getLogger(MySolrImpl.class);
	
	public MySolrImpl() {
		super();
	}
	
	public MySolrImpl(String config) {
		
		super(config);
	}

	@Override
	public SolrResult<?> find(String id, Map<String, Object> model) {

		Mapper mapper = this.config.get(id);

		if (mapper == null) {

			logger.info("not found mapper id=" + id);
			return null;
		}

		SolrQuery solrQuery = getQuery(model, mapper);

		solrQuery.setRows(SIZE);

		QueryResponse queryResponse = null;

		try {
			queryResponse = this.getSolrServer().query(solrQuery);
		} catch (SolrServerException e) {
			logger.error(e.getMessage(), e);
		}

		String resultType = mapper.getResultType();
		
		
		SolrDocumentList sdl = (SolrDocumentList) queryResponse.getResponse()
				.get("response");

		Wrapper wrapper = getWapper(mapper);

		SolrResult sr = getReturn(queryResponse,sdl, wrapper, mapper.getResultType());

		return sr;

	}

	@Override
	public SolrResult find(String id, Map<String, Object> model, int page,
			int size) {
		Mapper mapper = this.config.get(id);

		if (mapper == null) {

			logger.info("not found mapper id=" + id);
			return null;
		}

		SolrQuery solrQuery = getQuery(model, mapper);

		int start = page * size;

		if (logger.isDebugEnabled()) {

			StringBuilder sb = new StringBuilder();

			sb.append("page:").append(page).append(" start:").append(start)
					.append(" size:").append(size);

			logger.debug(sb.toString());
		}

		solrQuery.setStart(start);
		solrQuery.setRows(size);
		
		if(logger.isDebugEnabled()) {
			
			StringBuilder sb = new StringBuilder("start=");
			sb.append(start).append(" size=").append(size);
			
			logger.debug(sb.toString());
		}

		QueryResponse queryResponse = null;

		try {
			queryResponse = this.getSolrServer().query(solrQuery);
		} catch (SolrServerException e) {
			logger.error(e.getMessage(), e);
		}

		SolrDocumentList sdl = (SolrDocumentList) queryResponse.getResponse()
				.get("response");

		Wrapper wrapper = getWapper(mapper);

		SolrResult sr = getReturn(queryResponse,sdl, wrapper, mapper.getResultType());

		return sr;
	}
	
	public boolean updateSolr(String id, Map<String, Object> updateValues) {

		if (updateValues == null || updateValues.isEmpty()) {

			return false;
		}

		Map<String, Object> params = new HashMap<String, Object>();

		for (Entry<String, Object> entry : updateValues.entrySet()) {

			Map<String, Object> setSolrBean = new HashMap<String, Object>(1);
			
			String value = null;
			
			Object objValue = entry.getValue();
			
			if(objValue != null) {
				
				if(objValue instanceof java.util.Date) {
					
				Calendar cal = Calendar.getInstance();
				
				// 1、取得本地时间：
				cal.setTime((Date)objValue);

				// 2、取得时间偏移量：
                int zoneOffset = cal.get(Calendar.ZONE_OFFSET); 

                // 3、取得夏令时差：
                int dstOffset = cal.get(Calendar.DST_OFFSET); 
                
                // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
                cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset)); 

                logger.debug("格林威治时间:" + new Date(cal.getTimeInMillis())); 
					
					value = DATE_FORMAT.format(new Date(cal.getTimeInMillis()));
				} else {

					value = objValue.toString();
				}
			}

			setSolrBean.put("set", value);

			params.put(entry.getKey(), setSolrBean);
		}

		params.put("id", id);

		Map<String, Object> jsonMap = new TreeMap<String, Object>();
		// {"add":{
		// "doc":{"id":"1","gname":{"set":"va11lue"},"cid":{"set":1}},"boost":1.0,"overwrite":true,"commitWithin":1000}}

		jsonMap.put("doc", params);
		jsonMap.put("commitWithin", 1);

		Map<String, Object> req = new HashMap<String, Object>(1);

		req.put("add", jsonMap);

		JSONObject jsonObject = JSONObject.fromObject(req);

		String solrJson = jsonObject.toString();

		String url = this.solrHost + this.solrUrl;

		if (logger.isDebugEnabled()) {

			logger.debug("solrUrl:" + url);
			logger.debug("solrJson:" + solrJson);
		}

		String result = this.httpUtil.sendPost(url, solrJson);

		logger.debug("solrResult:" + result);

		return true;
	}

	public boolean updateSolr(List<String> ids,
			List<Map<String, Object>> updateValuesList) {

		if (ids == null || ids.isEmpty()) {

			return false;
		}

		if (updateValuesList == null) {

			return false;
		}

		int length = ids.size();

		if (length != updateValuesList.size()) {

			logger.debug("length no equel!");

			return false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");

		for (int i = 0; i < length; i++) {

			String id = ids.get(i);
			
			Map<String, Object> updateValues = updateValuesList.get(i);

			Map<String, Object> params = new HashMap<String, Object>();

			for (Entry<String, Object> entry : updateValues.entrySet()) {

				Map<String, Object> setSolrBean = new HashMap<String, Object>(1);

				setSolrBean.put("set", entry.getValue());

				params.put(entry.getKey(), setSolrBean);
			}

			params.put("id", id);

			Map<String, Object> jsonMap = new TreeMap<String, Object>();
			// {"add":{
			// "doc":{"id":"1","gname":{"set":"va11lue"},"cid":{"set":1}},"boost":1.0,"overwrite":true,"commitWithin":1000}}

			jsonMap.put("doc", params);
			jsonMap.put("commitWithin", 1);

			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			
			sb.append("\"add\":").append(jsonObject.toString());
			
			String last = (i == length - 1) ? "}":",";
			
			sb.append(last);

		}

		String solrJson = sb.toString();

		String url = this.solrHost + this.solrUrl;

		if (logger.isDebugEnabled()) {

			logger.debug("solrUrl:" + url);
			logger.debug("solrJson:" + solrJson);
		}

		String result = this.httpUtil.sendPost(url, solrJson);

		logger.debug("solrResult:" + result);

		return true;

	}
	
	public UpdateResponse addBean(Object obj,int commitWithinMs) throws IOException, SolrServerException {
		
		return this.getSolrServer().addBean(obj, commitWithinMs);
	}
	
	public UpdateResponse addBeans(Collection objs,int commitWithinMs) throws IOException, SolrServerException {
	
		return this.getSolrServer().addBeans(objs, commitWithinMs);
	}

	public UpdateResponse deleteById(String id,int commitWithinMs) throws SolrServerException, IOException {
		
		return this.getSolrServer().deleteById(id,commitWithinMs);
	}
	
	public UpdateResponse deleteByIds(List<String> ids,int commitWithinMs) throws SolrServerException, IOException {

		return this.getSolrServer().deleteById(ids,commitWithinMs);
	}
}

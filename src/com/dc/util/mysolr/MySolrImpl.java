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
	
	
	
}

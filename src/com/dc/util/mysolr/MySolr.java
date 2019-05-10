package com.dc.util.mysolr;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;

import com.dc.util.mysolr.bean.SolrResult;

public interface MySolr {
	
	public static final String PAGE = "page";
	public static final String SIZE = "size";
	
	public static final String LNG = "lng";
	public static final String LAT = "lat";
	
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	public SolrResult find(String queryId,Map<String,Object> params);
	
	public SolrResult find(String queryId,Map<String,Object> params,int page,int size);
	
//	public void setSolrServer(SolrServer solrServer);
}
package com.dc.util.mysolr.wrapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.solr.common.SolrDocument;

public class DefaultWrapper implements Wrapper {

	@Override
	public Map<String, Object> wrapper(SolrDocument doc) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.putAll(doc);
		
		return map;
	}

	@Override
	public Object wrapper(Object obj) {
		
		return obj;
	}
}
package com.dc.util.mysolr.wrapper;

import org.apache.solr.common.SolrDocument;

public interface Wrapper {

	public Object wrapper(SolrDocument doc);
	
	default public Object wrapper(Object obj) {
		
		return obj;
	}
}

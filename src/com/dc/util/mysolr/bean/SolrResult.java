package com.dc.util.mysolr.bean;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.response.FacetField;

public class SolrResult<T> {

	private long count;
	
	private List<T> list;
	
	private List<FacetField> facets;
	
	private Map<String,Map<String, Object>> fusions;
	
	private List<Map<String, Object>> footer;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<FacetField> getFacets() {
		return facets;
	}

	public void setFacets(List<FacetField> facets) {
		this.facets = facets;
	}

	public List<Map<String, Object>> getFooter() {
		return footer;
	}

	public void setFooter(List<Map<String, Object>> footer) {
		this.footer = footer;
	}

	public Map<String, Map<String, Object>> getFusions() {
		return fusions;
	}

	public void setFusions(Map<String, Map<String, Object>> fusions) {
		this.fusions = fusions;
	}

}
package com.dc.util.mysolr.config;

import java.util.Map;

import com.dc.util.mysolr.config.bean.query.Mapper;

public interface ConfigFactory {
	
	public Map<String , Mapper> getConfig(String file) throws Exception;
}

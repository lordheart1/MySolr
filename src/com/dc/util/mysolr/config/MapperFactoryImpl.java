package com.dc.util.mysolr.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.exolab.castor.xml.Unmarshaller;
import org.xml.sax.InputSource;

import com.dc.util.mysolr.config.bean.query.Mapper;
import com.dc.util.mysolr.config.bean.query.Mappers;

public class MapperFactoryImpl implements ConfigFactory {

	@Override
	public Map<String, Mapper> getConfig(String file)  throws Exception {
		
		InputStream input =  Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
			
		InputSource source = new InputSource(input);
		
		
		Unmarshaller unmarshaller = new Unmarshaller();
		unmarshaller.setClass(Mappers.class);
		unmarshaller.setValidation(false);
		Mappers mappers = (Mappers) unmarshaller.unmarshal(source);
		
		Map<String , Mapper> map = new HashMap<String, Mapper>();
		
		for (Mapper query : mappers.getMapper()) {
			String id = query.getId();
			
			map.put(id, query);
		}
		
		return map;
	}

}

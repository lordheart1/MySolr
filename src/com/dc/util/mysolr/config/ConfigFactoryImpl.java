package com.dc.util.mysolr.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.exolab.castor.xml.Unmarshaller;
import org.xml.sax.InputSource;

import com.dc.util.mysolr.config.bean.solr.File;
import com.dc.util.mysolr.config.bean.solr.SolrConfig;

public class ConfigFactoryImpl implements ConfigFactory {

	private ConfigFactory configFactory = new MapperFactoryImpl();

	@Override
	public Map<String, com.dc.util.mysolr.config.bean.query.Mapper> getConfig(
			String file) throws Exception {
		Map<String, com.dc.util.mysolr.config.bean.query.Mapper> r = new HashMap<String, com.dc.util.mysolr.config.bean.query.Mapper>();

		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(file);

		InputSource source = new InputSource(input);

		Unmarshaller unmarshaller = new Unmarshaller();
		unmarshaller.setClass(SolrConfig.class);
		unmarshaller.setValidation(false);
		SolrConfig solrConfig = (SolrConfig) unmarshaller.unmarshal(source);

		File[] ms = solrConfig.getFile();

		for (File m : ms) {

			String queryFile = m.getResource();

			Map<String, com.dc.util.mysolr.config.bean.query.Mapper> mr = this.configFactory
					.getConfig(queryFile);

			r.putAll(mr);
		}

		return r;
	}

}

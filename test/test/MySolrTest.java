package test;



import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.dc.util.mysolr.MySolrImpl;
import com.dc.util.mysolr.bean.SolrResult;


public class MySolrTest {

	private String solrHost = "http://192.168.81.202:8983/solr/products";
	
	private String pId = "81500000000016";
	
	@Test
	void testMySolr() {
		
		MySolrImpl mySolr = new MySolrImpl();
		
		HttpSolrServer solrServer = new org.apache.solr.client.solrj.impl.HttpSolrServer(this.solrHost);
		
		mySolr.setSolrServer(solrServer);
		
		Map<String,Object> params = new HashMap<String,Object>(1);
		
		params.put("p_id", this.pId);
		
		SolrResult solrResult = mySolr.find("test", params);
		
		Map<String,Object> row = (Map<String,Object>)solrResult.getList().get(0);
		
		System.out.println(row);
	}

}

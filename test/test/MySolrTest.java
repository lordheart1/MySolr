package test;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.junit.jupiter.api.Test;

import com.dc.util.mysolr.MySolr;
import com.dc.util.mysolr.MySolrImpl;
import com.dc.util.mysolr.bean.SolrResult;


public class MySolrTest {

	private String solrHost = "http://192.168.81.202:8983/solr/scan_detail";
	
	private String pId = "c3d5b281-7d05-4ca2-8614-4fc87b639f76";
	
	private String country = "CN";
	
	private String lat = "121.44735167147903";
	private String lng = "31.194000352627313";
	
	
	private MySolr mySolr;
	
	public MySolrTest() {
		
		MySolrImpl mySolr = new MySolrImpl();
		
		HttpSolrServer solrServer = new org.apache.solr.client.solrj.impl.HttpSolrServer(this.solrHost);
		
		mySolr.setSolrServer(solrServer);
		
		this.mySolr = mySolr;
	}
	
	@Test
	void testSampleMySolr() {
		
		Map<String,Object> params = new HashMap<String,Object>(1);
		
		params.put("p_id", this.pId);
		
		SolrResult solrResult = mySolr.find("test", params);
		
		Map<String,Object> row = (Map<String,Object>)solrResult.getList().get(0);
		
		System.out.println(row);
	}
	
	@Test
	public void testDistance() {
		
		Map<String,Object> params = new HashMap<String,Object>(3);
		
		params.put("country", this.country);
		params.put(MySolr.LAT, this.lat);
		params.put(MySolr.LNG, this.lng);
		
		SolrResult solrResult = mySolr.find("spatial_test", params);
		
		for(Object row : solrResult.getList()) {
			
			System.out.println(row);
		}
		
		
	}
	
	@Test
	public void testDistanceFacet() {
		
		Map<String,Object> params = new HashMap<String,Object>(3);
		
		params.put("country", this.country);
		params.put(MySolr.LAT, this.lat);
		params.put(MySolr.LNG, this.lng);
		
		SolrResult solrResult = mySolr.find("spatial_facet_test", params);
		
		List facets = solrResult.getFacets();
		
		for(Object facet : facets) {
			System.out.println(facet);
		}
	}
	
	@Test
	public void testDistanceFusion() {
		
		Map<String,Object> params = new HashMap<String,Object>(3);
		
		params.put("country", this.country);
		params.put(MySolr.LAT, this.lat);
		params.put(MySolr.LNG, this.lng);
		
		SolrResult solrResult = mySolr.find("spatial_fusion_test", params);
		
		Map facets = solrResult.getFusions();
		
		for(Object facet : facets.entrySet()) {
			System.out.println(facet);
		}
	}
}
package galileo.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.travelzen.flight.FlightClient;
import com.travelzen.flight.api.galileo.bean.GalileoResponse;
import com.travelzen.flight.api.galileo.pojo.ArrayOfString;
import com.travelzen.flight.api.galileo.pojo.CabinClass;
import com.travelzen.flight.api.galileo.pojo.Search;
import com.travelzen.flight.api.galileo.pojo.SearchRequest;
import com.travelzen.flight.api.galileo.pojo.SearchResponse;
import com.travelzen.flight.api.galileo.pojo.SearchResult;
import com.travelzen.flight.api.galileo.services.GalileoTravelAgentService;
import com.travelzen.flight.api.utils.GalileoXmlDataFilter;
import com.travelzen.flight.api.utils.XmlConvert;

public class TestGalileoSearch {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		FlightClient flightClient = FlightClient.getInstance();
		GalileoTravelAgentService galileoTravelAgentService = flightClient.getGalileoTravelAgentService();
//		
		SearchRequest searchRequest = new SearchRequest();
		SearchResult searchResult = null;
//		searchRequest.setAdult(1);
		searchRequest.setChild(1);
//		searchRequest.setCabinClass(CabinClass.FIRST);
		searchRequest.setCabinClass(CabinClass.ECONOMY);
		searchRequest.setFromCity("SHA");
		searchRequest.setFromDate("20160622");
		searchRequest.setIsDirectFlightOnly(false);
		searchRequest.setToCity("PUS");
		ArrayOfString arrayOfString= new ArrayOfString();
		arrayOfString.getString().add("AA");
		searchRequest.setLPermittedCarriers(new ArrayOfString());
//		searchRequest.setLProhibitedCarriers(new ArrayOfString());
		searchRequest.setMaxRecord(10);
		searchRequest.setSChargeAmt("0");
		searchRequest.setSChargeBy("R");
//		searchRequest.setSource("Uapi");
		searchRequest.setSOverridePCC("");
		searchRequest.setSSourceMarkUpBy("R");
		searchRequest.setDSourceMarkUpAmt(new BigDecimal(0));
		searchRequest.setTripType("1");
		Search search = new Search();
        search.setOSearch(searchRequest);
		
			XmlConvert xmlConvert =null;
			GalileoResponse galileoResponse = null;
			SearchResponse response = null;
		    flightClient = FlightClient.getInstance();
	        galileoTravelAgentService = flightClient.getGalileoTravelAgentService();
	        xmlConvert = new XmlConvert(new GalileoXmlDataFilter());
	        galileoResponse = galileoTravelAgentService.galileoSearch(UUID.randomUUID().toString(), xmlConvert.encode(search));
	        response = xmlConvert.decode(galileoResponse.getValue(), com.travelzen.flight.api.galileo.pojo.SearchResponse.class);
	        System.out.println(JSON.toJSONString(response, true));
	        System.out.println(System.currentTimeMillis()-start);
//	        if(null != response){
//	        	 searchResult = response.getSearchResult();
//	        	 System.out.println("searchResult : "+searchResult.getRoutings().getRouteing().get(0).toString());
//	        	 System.out.println(System.currentTimeMillis()-start);
//	        }
	        
	}

}

package com.travelzen.fare.galileo.convertor.request;

import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.flight.api.galileo.pojo.SearchResult;

public class SearchResultToGalileoShoppingResponseConvertor {
	
	public static GalileoShoppingResponse searchResultToGalileoShoppingResponse(SearchResult searchResult){
		GalileoShoppingResponse galileoShoppingResponse = null;
		if(null != searchResult){
			galileoShoppingResponse = new GalileoShoppingResponse();
			
			if(null != searchResult.getId() && searchResult.getId().equals("") != false){
				
			}
		}
		
		
		
		return galileoShoppingResponse;
	}

}

package com.travelzen.fare.galileo.shopping.route.channel;

import java.util.List;

import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;


public class GalileoShoppingRouteWriteData {
	
	private String queryKey;
	private List<GalileoShoppingRoute> galileoShoppingRouteList;
	
	public String getQueryKey() {
		return queryKey;
	}
	
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}
	
	public List<GalileoShoppingRoute> getGalileoShoppingRouteList() {
		return galileoShoppingRouteList;
	}
	
	public void setGalileoShoppingRouteList(
			List<GalileoShoppingRoute> galileoShoppingRouteList) {
		this.galileoShoppingRouteList = galileoShoppingRouteList;
	}

}

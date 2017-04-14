package com.travelzen.fare.galileo.shopping.route.searchUtil;

import com.mongodb.BasicDBObject;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;

public class GalileoShoppingRouteSearchUtil {
	
	public static void genQueryKey(BasicDBObject basicDBObject, String queryKey) {
		if (basicDBObject == null) {
			return;
		}
		
		basicDBObject.put(GalileoShoppingRoute._Fields.QUERY_KEY.getFieldName(), queryKey);
	}
	
	public static void genId(BasicDBObject basicDBObject, Long routeId) {
		if (basicDBObject == null) {
			return;
		}
		
		basicDBObject.put(GalileoShoppingRoute._Fields.ID.getFieldName(), routeId);
	}
	
	public static void genRouteKey(BasicDBObject basicDBObject, String routeKey) {
		if (basicDBObject == null) {
			return;
		}
		
		basicDBObject.put(GalileoShoppingRoute._Fields.ROUTE_KEY.getFieldName(), routeKey);
	}

}

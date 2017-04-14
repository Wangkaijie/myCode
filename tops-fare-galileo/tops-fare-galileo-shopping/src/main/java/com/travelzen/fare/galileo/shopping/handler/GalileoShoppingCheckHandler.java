package com.travelzen.fare.galileo.shopping.handler;

import java.util.List;

import org.slf4j.Logger;

import com.travelzen.fare.galileo.shopping.db.dao.GalileoShoppingRouteDao;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class GalileoShoppingCheckHandler {
	
private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingCheckHandler.class);
	
	
	public static GalileoShoppingRoute  galileoGetRouteFromDB(String routeId) throws Exception {
		return GalileoShoppingRouteDao.getRoutesById(Long.parseLong(routeId));
		/**int skipNum=0;
		int limitNum=100;
		
		List<GalileoShoppingRoute> galileoShoppingRouteList = null;
		BasicDBObject dbObject = new BasicDBObject();
		
		GalileoShoppingRouteSearchUtil.genId(dbObject, Long.parseLong(routeId));
		
		galileoShoppingRouteList = MongoDBUtil.searchData(routeTableCtrlWithCheck, dbObject, null, skipNum, limitNum, GalileoShoppingRoute.class);
		
		if (galileoShoppingRouteList.size() <= 0) {
			return null;
		}
		
		
		if (galileoShoppingRouteList.size() > 1) {
			throw new Exception("in galileoGetRouteFromDB, the size of id =(" + routeId + ") is more than one");
		}

		
		return galileoShoppingRouteList.get(0);*/
	}
	
	
	public static List<GalileoShoppingRoute>  galileoGetRouteFromDBByRouteKey(String routeKey) throws Exception {
		return GalileoShoppingRouteDao.getRoutesByRouteKeys(routeKey);
		/**int skipNum=0;
		int limitNum=100;
		
		List<GalileoShoppingRoute> galileoShoppingRouteList = null;
		BasicDBObject dbObject = new BasicDBObject();
		
		GalileoShoppingRouteSearchUtil.genRouteKey(dbObject, routeKey);
		logger.info("in galileoGetRouteFromDBByRouteKey, dbObject: "+dbObject);
		galileoShoppingRouteList = MongoDBUtil.searchData(routeTableCtrlWithCheck, dbObject, null, skipNum, limitNum, GalileoShoppingRoute.class);
		logger.info("in galileoGetRouteFromDBByRouteKey: "+galileoShoppingRouteList);
		return galileoShoppingRouteList;*/
	}

}

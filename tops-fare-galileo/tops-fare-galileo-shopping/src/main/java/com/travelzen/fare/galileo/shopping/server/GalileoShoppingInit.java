package com.travelzen.fare.galileo.shopping.server;

import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.util.business.req.ShoppingReqDao;
import com.travelzen.fare.util.common.cache.ShoppingRouteDBCache;

;

public class GalileoShoppingInit {

    private static final ShoppingRouteDBCache cache = new ShoppingRouteDBCache("GALIEOSHOPPING", null);

//    private static final CombinationCacheChannel flightCache =new CombinationCacheChannel("PAPERFAREFLIGHT",null);

    private static final ShoppingReqDao<GalileoShoppingRequest> requestDao=new ShoppingReqDao<GalileoShoppingRequest>(cache.getRequest());


    private GalileoShoppingInit() {
    }

    public static ShoppingRouteDBCache getCacheInstance(){
        return cache;
    }

    public static ShoppingReqDao getRequestDao(){

        return requestDao;

    }

//    public static CombinationCacheChannel getFlightCache(){
//        return flightCache;
//    }


    public static void changeVersion(String version) {

        cache.changeVersion(version);

    }
}

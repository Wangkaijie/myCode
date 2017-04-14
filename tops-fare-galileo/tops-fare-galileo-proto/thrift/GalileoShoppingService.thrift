namespace java com.travelzen.fare.galileo.shopping.service

include "GalileoShoppingRequestResponse.thrift"
include "GalileoShoppingRoute.thrift"
include "GalileoShoppingDisplayFareRule.thrift"



service GalileoShoppingService {
  GalileoShoppingRequestResponse.GalileoShoppingResponse galileoFareSearch(1:GalileoShoppingRequestResponse.GalileoShoppingRequest request);

  GalileoShoppingRoute.GalileoShoppingRoute galileoGetRouteFromDB(1:string id);
  list< GalileoShoppingRoute.GalileoShoppingRoute> galileoGetRouteFromDBByRouteKey(1:string routeKey);
  
  GalileoShoppingDisplayFareRule.GalileoShoppingDisplayFareRule galileoGetFareRule(1:string GalileoShoppingFareRuleRequest);
  
  bool refreshCacheByRouteKey(1:string routeKey ,2:GalileoShoppingRequestResponse.GalileoShoppingRequest request);
  
  bool refreshCacheByRouteId(1:i64 routeId ,2:GalileoShoppingRequestResponse.GalileoShoppingRequest request);
  
}
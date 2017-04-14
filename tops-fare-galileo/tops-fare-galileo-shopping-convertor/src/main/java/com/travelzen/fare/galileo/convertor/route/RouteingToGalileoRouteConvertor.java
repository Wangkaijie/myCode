package com.travelzen.fare.galileo.convertor.route;

import com.travelzen.fare.galileo.convertor.common.FareTypeConvertor;
import com.travelzen.fare.galileo.convertor.farerule.RuleToGalileoRuleConvertor;
import com.travelzen.fare.galileo.convertor.flight.SegmentsToGalileoSegmentsConvertor;
import com.travelzen.flight.api.galileo.bean.GalileoRoute;
import com.travelzen.flight.api.galileo.pojo.Routeing;

public class RouteingToGalileoRouteConvertor {
	
	public static GalileoRoute routeingToGalileoRoute(Routeing routeing)throws Exception{
		GalileoRoute galileoRoute = null;
		if(null != routeing){
			galileoRoute = new GalileoRoute();
			galileoRoute.setAdult(routeing.getAdult());
			galileoRoute.setAdultOrgPrice(routeing.getAdultOrgPrice());
			galileoRoute.setAdultOrgTax(routeing.getAdultOrgTax());
			galileoRoute.setAdultPrice(routeing.getAdultPrice());
			galileoRoute.setAdultTax(routeing.getAdultTax());
			galileoRoute.setAdultTaxType(routeing.getAdultTaxType());
			galileoRoute.setChild(routeing.getChild());
			galileoRoute.setChildOrgPrice(routeing.getChildOrgPrice());
			galileoRoute.setChildOrgTax(routeing.getChildOrgTax());
			galileoRoute.setChildPrice(routeing.getChildPrice());
			galileoRoute.setChildTax(routeing.getChildTax());
			galileoRoute.setChildTaxType(routeing.getChildTaxType());
			galileoRoute.setFareBasis(routeing.getFareBasis());
			galileoRoute.setFareType(FareTypeConvertor.searchFareTypeToGalileoFareType(routeing.getFareType()));
			if(null != routeing.getFromSegments()){
				galileoRoute.setFromSegments(
						SegmentsToGalileoSegmentsConvertor.segmentsToGalileoSegments(routeing.getFromSegments().getSegment()));
			}
			if(null != routeing.getRetSegments()){
				galileoRoute.setRetSegments(
						SegmentsToGalileoSegmentsConvertor.segmentsToGalileoSegments(routeing.getRetSegments().getSegment()));
			}
			galileoRoute.setRule(RuleToGalileoRuleConvertor.ruleToGalileoRule(routeing.getRule()));
		}
		
		return galileoRoute;
	}

}

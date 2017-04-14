package com.travelzen.fare.galileo.convertor.farerule;

import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.flight.api.galileo.pojo.Rule;

public class GalileoVerifyFareRuleToGalileoDisplayFareRuleConvertor {
	
public static GalileoShoppingDisplayFareRule fromGalileoVerifyFareRule(Rule rule)throws Exception{
		
	GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule = new GalileoShoppingDisplayFareRule();
		
		if(null != rule){
			if(null != rule.getRefund()){
				galileoShoppingDisplayFareRule.setRefund(rule.getRefund());
			}
			
			if(null != rule.getEndorse()){
				galileoShoppingDisplayFareRule.setEndorse(rule.getEndorse());
			}
			
			if(null != rule.getBaggage()){
				galileoShoppingDisplayFareRule.setBaggage(rule.getBaggage());
			}
			
			if(null != rule.getOther()){
				galileoShoppingDisplayFareRule.setOther(rule.getOther());
			}
		}
		return galileoShoppingDisplayFareRule;
	}

}

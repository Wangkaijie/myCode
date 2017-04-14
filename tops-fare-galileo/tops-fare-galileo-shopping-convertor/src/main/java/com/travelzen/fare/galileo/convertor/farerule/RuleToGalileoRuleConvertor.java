package com.travelzen.fare.galileo.convertor.farerule;

import com.travelzen.flight.api.galileo.bean.GalileoRule;
import com.travelzen.flight.api.galileo.pojo.Rule;

public class RuleToGalileoRuleConvertor {
	
	public static GalileoRule ruleToGalileoRule(Rule rule)throws Exception{
		GalileoRule galileoRule = null;
		if(null != rule){
			galileoRule = new GalileoRule();
			galileoRule.setBaggage(rule.getBaggage());
			galileoRule.setEndorse(rule.getEndorse());
			galileoRule.setRefund(rule.getRefund());
			galileoRule.setOther(rule.getOther());
		}
		
		return galileoRule;
	}

}

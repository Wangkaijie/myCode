package com.travelzen.fare.galileo.shopping.farerule.searchUtil;

import com.mongodb.BasicDBObject;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;

public class GalileoShoppingFareRuleSearchUtil {
	
	public static void genFareRuleInfoQueryMD5(BasicDBObject basicDBObject, String fareRuleQueryMD5){
		if(null ==basicDBObject){
			return;
		}
		
		basicDBObject.put(GalileoShoppingDisplayFareRule._Fields.ID.getFieldName(), fareRuleQueryMD5);
	}

}

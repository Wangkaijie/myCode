package com.travelzen.fare.galileo.shopping.db.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.travelzen.fare.galileo.shopping.db.table.GalileoShoppingFareRuleTableCtrl;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.fare.galileo.shopping.farerule.searchUtil.GalileoShoppingFareRuleSearchUtil;
import com.travelzen.fare.util.common.mongo.MongoDBCtrl;
import com.travelzen.fare.util.common.mongo.util.MongoDBUtil;

public class GalileoShoppingFareRuleDao {
private static MongoDBCtrl<GalileoShoppingDisplayFareRule> instance = GalileoShoppingFareRuleTableCtrl.getInstance();
	
	public static GalileoShoppingDisplayFareRule searchGalileoFareRuleInfoById(String id) throws Exception{
		List<GalileoShoppingDisplayFareRule> fareRuleInfoList=null;
		
		BasicDBObject basicDBObject=new BasicDBObject();
		GalileoShoppingFareRuleSearchUtil.genFareRuleInfoQueryMD5(basicDBObject, id);
		
		fareRuleInfoList=MongoDBUtil.searchData(instance, basicDBObject, null, 0, 100, GalileoShoppingDisplayFareRule.class);
		
		if(null == fareRuleInfoList || fareRuleInfoList.size() == 0){
			return null;
		}
		if(fareRuleInfoList.size()>1){
			throw new Exception("in searchJiujiuFareRuleInfoById, farerule of id("+id+") is more than one");
		}
		return fareRuleInfoList.get(0);
	}
	
	
	public static void saveFareRule(GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule)throws Exception{
		BasicDBObject basicDBObjectQuery=new BasicDBObject();
		GalileoShoppingFareRuleSearchUtil.genFareRuleInfoQueryMD5(basicDBObjectQuery, galileoShoppingDisplayFareRule.getId());
		
		instance.update(basicDBObjectQuery, galileoShoppingDisplayFareRule, true, false, false);
		
	}

}

package com.travelzen.fare.galileo.shopping.db.table;

import com.travelzen.fare.galileo.shopping.config.FareShoppingMongoDBConfig;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.fare.util.common.mongo.MongoDBCtrl;
import com.travelzen.fare.util.common.mongo.table.MongoDBTableInstance;

public class GalileoShoppingFareRuleTableCtrl extends MongoDBTableInstance<GalileoShoppingDisplayFareRule>{
	
	private static MongoDBCtrl<GalileoShoppingDisplayFareRule> mongoDBCtrlInstance=null;
	static{
		mongoDBCtrlInstance=(MongoDBCtrl<GalileoShoppingDisplayFareRule>)createInstance(
				FareShoppingMongoDBConfig.getMongoUri(),
				FareShoppingMongoDBConfig.getDBName(),
				FareShoppingMongoDBConfig.getGalileoDisplayFareRuleTable());
	}
	
	public static MongoDBCtrl<GalileoShoppingDisplayFareRule> getInstance(){
		return mongoDBCtrlInstance;
	}


}

package com.travelzen.fare.galileo.shopping.db.table;

import com.travelzen.fare.galileo.shopping.config.FareShoppingMongoDBConfig;
import com.travelzen.fare.util.common.mongo.MongoDBCtrl;
import com.travelzen.fare.util.common.mongo.table.MongoDBTableInstance;
import com.travelzen.fare.util.system.AutoIncTable;

public class GalileoShoppingAutoIncTableCtrl extends MongoDBTableInstance<AutoIncTable>{
	 private static MongoDBCtrl<AutoIncTable> mongoDBCtrlInstance = null;
	    static {
	        mongoDBCtrlInstance = (MongoDBCtrl<AutoIncTable>) createInstance(
	        		FareShoppingMongoDBConfig.getMongoUri(),
	        		FareShoppingMongoDBConfig.getDBName(), 
	        		FareShoppingMongoDBConfig.getGalileoAutoIncTable());
	    }

	    private GalileoShoppingAutoIncTableCtrl() {
	    }

	    public static MongoDBCtrl<AutoIncTable> getInstance() {
	        return mongoDBCtrlInstance;
	    }

}

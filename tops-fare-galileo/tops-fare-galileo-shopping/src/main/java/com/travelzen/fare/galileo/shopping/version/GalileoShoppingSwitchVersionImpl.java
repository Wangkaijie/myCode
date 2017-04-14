package com.travelzen.fare.galileo.shopping.version;

import com.mongodb.BasicDBObject;
import com.travelzen.fare.galileo.shopping.config.FareShoppingMongoDBConfig;
import com.travelzen.fare.galileo.shopping.db.table.GalileoShoppingAutoIncTableCtrl;
import com.travelzen.fare.galileo.shopping.db.table.GalileoShoppingVersionTableCtrl;
import com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.fare.util.common.mongo.MongoDBCtrl;
import com.travelzen.fare.util.common.mongo.version.FareSwitchVersion;

public class GalileoShoppingSwitchVersionImpl extends FareSwitchVersion{
		

		public GalileoShoppingSwitchVersionImpl()throws Exception{
			 super(FareShoppingMongoDBConfig.getGalileoVersionTable(), 
					 GalileoShoppingAutoIncTableCtrl.getInstance(), GalileoShoppingVersionTableCtrl.getInstance());
		}

	    @Override
	    public void switchVersion() throws Exception {
	    }
	    
	    public static void createRouteSeqNoIndex(MongoDBCtrl<GalileoShoppingRoute> mongoDBCtrl) throws Exception {
	    	BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingRoute._Fields.SEQ_NO.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }
	    
	    public static void createRouteQueryKeyIndex(MongoDBCtrl<GalileoShoppingRoute> mongoDBCtrl) throws Exception {
	        BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingRoute._Fields.QUERY_KEY.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }
	    
	    public static void createRouteRouteKeyIndex(MongoDBCtrl<GalileoShoppingRoute> mongoDBCtrl) throws Exception {
	        BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingRoute._Fields.ROUTE_KEY.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }
	    
	    public static void createRouteUpdateTimeIndex(MongoDBCtrl<GalileoShoppingRoute> mongoDBCtrl) throws Exception {
	        BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingRoute._Fields.LAST_UPDATE_DATE_TIME.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }
	    
	    public static void createRouteIdIndex(MongoDBCtrl<GalileoShoppingRoute> mongoDBCtrl) throws Exception {
	        BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingRoute._Fields.ID.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }

	    
	    public static void createErrorUpdateTimeIndex(MongoDBCtrl<GalileoShoppingErrorTable> mongoDBCtrl) throws Exception {
	        BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingErrorTable._Fields.LAST_UPDATE_TIME.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }
	    
	    private static void createRouteRemoveIndex(MongoDBCtrl<GalileoShoppingRoute> mongoDBCtrl) throws Exception {
	    	BasicDBObject keysDbObject = new BasicDBObject();
	        
	        keysDbObject.put(GalileoShoppingRoute._Fields.SEQ_NO.getFieldName(), 1);
	        keysDbObject.put(GalileoShoppingRoute._Fields.QUERY_KEY.getFieldName(), 1);
	        
	        mongoDBCtrl.createIndex(keysDbObject, null);
	    }
	    

	    @Override
	    public long getVersion() {
	        return 3l;
	    }

}

package com.travelzen.fare.galileo.shopping.config;

import com.travelzen.framework.config.tops.TopsConfReader;
import com.travelzen.framework.config.tops.TopsConfEnum.ConfScope;

public class FareShoppingMongoDBConfig {
	 private final static String mongoDBUri = "galileoshopping.mongo.uri";
	    private final static String mongoDBAddr = TopsConfReader.getConfContent("properties/mongo-database.properties",
	            mongoDBUri, ConfScope.R);
	    
	    private final static String galileoAutoIncTable 					= "galileoAutoIncTable";
	    private final static String galileoVersionTable					= "galileoVersionTable";
	    
	    private final static String galileoFareRouteTable					= "galileoFareRouteTable";
	    private final static String galileoFareRouteTableSeqNo				= "galileoFareRouteTableSeqNo";
	    
	    private final static String galileoFareErrorTable					= "galileoFareErrorTable";
	    
	    private final static String galileoDisplayFareRuleTable			= "galileoDisplayFareRuleTable";
	    
	    private final static String galileoShoppingRouteWithCheckTable		= "galileoFareRouteWithCheckTable";
	    
	    FareShoppingMongoDBConfig() throws Exception {
	        if (mongoDBAddr == null) {
	            throw new Exception("in ShoppingMongoDBConfig, the mongoDBAddr is null");
	        }
	    }
	    
	    public static String getMongoUri() {
	        return mongoDBAddr;
	    }
	    
	    public static String getDBName() {
	        return mongoDBAddr==null ? null : mongoDBAddr.substring(mongoDBAddr.lastIndexOf("/")+1);
	    }
	    
	    public static String getGalileoAutoIncTable() {
	    	return galileoAutoIncTable;
	    }
	    
	    public static String getGalileoVersionTable() {
	    	return galileoVersionTable;
	    }

	    public static String getGalileoFareRouteTable() {
	    	return galileoFareRouteTable;
	    }
	    
	    public static String getGalileoFareRouteTableSeqNo() {
	    	return galileoFareRouteTableSeqNo;
	    }
	    
	    public static String getGalileoFareErrorTable() {
	    	return galileoFareErrorTable;
	    }
	    
	    public static String getGalileoDisplayFareRuleTable(){
	    	return galileoDisplayFareRuleTable;
	    }
	    
	    public static String getGalileoShoppingRouteWithCheckTable() {
	    	return galileoShoppingRouteWithCheckTable;
	    }

}

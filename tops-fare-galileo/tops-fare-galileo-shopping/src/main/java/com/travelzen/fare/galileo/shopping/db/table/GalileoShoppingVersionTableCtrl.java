package com.travelzen.fare.galileo.shopping.db.table;

import com.travelzen.fare.galileo.shopping.config.FareShoppingMongoDBConfig;
import com.travelzen.fare.util.common.mongo.MongoDBCtrl;
import com.travelzen.fare.util.common.mongo.table.MongoDBTableInstance;
import com.travelzen.fare.util.system.VersionTable;

public class GalileoShoppingVersionTableCtrl extends MongoDBTableInstance<VersionTable>{
    private static MongoDBCtrl<VersionTable> mongoDBCtrlInstance = null;
    static {
        mongoDBCtrlInstance = (MongoDBCtrl<VersionTable>) createInstance(
        		FareShoppingMongoDBConfig.getMongoUri(),
        		FareShoppingMongoDBConfig.getDBName(), 
        		FareShoppingMongoDBConfig.getGalileoVersionTable());
    }

    private GalileoShoppingVersionTableCtrl() {
    }

    public static MongoDBCtrl<VersionTable> getInstance() {
        return mongoDBCtrlInstance;
    }

}

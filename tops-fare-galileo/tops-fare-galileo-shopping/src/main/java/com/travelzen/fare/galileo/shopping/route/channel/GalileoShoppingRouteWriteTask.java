package com.travelzen.fare.galileo.shopping.route.channel;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;

import com.travelzen.fare.galileo.shopping.config.FareShoppingMongoDBConfig;
import com.travelzen.fare.galileo.shopping.db.table.GalileoShoppingAutoIncTableCtrl;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.fare.galileo.shopping.server.GalileoShoppingInit;
import com.travelzen.fare.util.common.channel.ChannelWriteData;
import com.travelzen.fare.util.common.channel.ChannelWriteData.ErrorInfo;
import com.travelzen.fare.util.common.channel.ChannelWriteTask;
import com.travelzen.fare.util.common.mongo.MongoDBCtrl;
import com.travelzen.fare.util.common.mongo.util.MongoDBUtil;
import com.travelzen.fare.util.system.AutoIncTable;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.tops.fare.channel.CacheDataChannel;
import com.travelzen.tops.fare.channel.CacheStructure.CacheData;
import com.travelzen.tops.fare.channel.CacheStructure.CacheOpt;
import com.travelzen.tops.fare.channel.CacheStructure.CacheOpt.ErrorMsg;
import com.travelzen.tops.fare.channel.TimeDataChannel;
import com.travelzen.tops.fare.framework.utils.SerializeUtils;

public class GalileoShoppingRouteWriteTask extends ChannelWriteTask{
	
	private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingRouteWriteTask.class);
    
    private static GalileoShoppingRouteWriteTask taskInstance = new GalileoShoppingRouteWriteTask();
    private static MongoDBCtrl<AutoIncTable> autoIncTableCtrl = GalileoShoppingAutoIncTableCtrl.getInstance();
   // private static MongoDBCtrl<GalileoShoppingRoute> routeTableCtrlWithCheck = GalileoShoppingRouteTableWithCheckCtrl.getInstance();
    private static CacheDataChannel cacheChannel =GalileoShoppingInit.getCacheInstance().getDataInstance();
    private static TimeDataChannel timeDataChannel=GalileoShoppingInit.getCacheInstance().getTimeInstance();
    
    public static GalileoShoppingRouteWriteTask getInstance() {
        return taskInstance;
    }
    
    protected void operator(ChannelWriteData routeWriteData) throws Exception {
        if (routeWriteData == null) {
            throw new Exception("in GalileoShoppingRouteWriteTask.operator, the argument is null");
        }
        
        GalileoShoppingRouteWriteOpType opType = (GalileoShoppingRouteWriteOpType) routeWriteData.getOpEnum();
        GalileoShoppingRouteWriteData galileoShoppingRouteWriteData = (GalileoShoppingRouteWriteData) routeWriteData.getData();
        
        if (opType == null) {
            throw new Exception("in routeWriteData, the optype is null");
        }
        
        switch (opType) {
        case INSERTWITHQUERY:
        	insertWithQuery(galileoShoppingRouteWriteData.getQueryKey(), 
        			galileoShoppingRouteWriteData.getGalileoShoppingRouteList(),routeWriteData.getErrorInfo());
            break;
//        case UPDATEVERIFYROUTE:
//        	IbeplusShoppingUpdatePriceRouteData ibeplusShoppingUpdatePriceRouteData=(IbeplusShoppingUpdatePriceRouteData)routeWriteData.getObject();
//        	updateRoutePrice(ibeplusShoppingUpdatePriceRouteData.routeID,ibeplusShoppingUpdatePriceRouteData.ibeplusShoppingRoute);
//        	break;
        }
    }
    
    private void insertWithQuery(String queryKey, List<GalileoShoppingRoute> galileoShoppingRouteList,ErrorInfo error) throws Exception {
    	
    	  if (error==null) {
  			
    			
    	       GalileoShoppingRoute galileoShoppingRoute = null;
    	
       /* if (queryKey == null || queryKey.equals("") == true || galileoShoppingRouteList == null || 
        		galileoShoppingRouteList.size() <= 0) {
            throw new Exception("in insert, The argument is null");
        }
        
        BasicDBObject deleteDBObject = new BasicDBObject();
        GalileoShoppingRouteSearchUtil.genQueryKey(deleteDBObject, queryKey);
        
        routeTableCtrl.remove(deleteDBObject, false);
        */
       long  startId = MongoDBUtil.autoInc(autoIncTableCtrl, FareShoppingMongoDBConfig.getGalileoFareRouteTable(), galileoShoppingRouteList.size());
      //  startSeqNo = MongoDBUtil.autoInc(autoIncTableCtrl, FareShoppingMongoDBConfig.getGalileoFareRouteTableSeqNo(), galileoShoppingRouteList.size());
        
        startId = startId - galileoShoppingRouteList.size() + 1;
        //startSeqNo = startSeqNo - galileoShoppingRouteList.size() + 1;
        int i;
        for (i = 0; i <galileoShoppingRouteList.size(); ++i, ++startId) {
        	galileoShoppingRoute = galileoShoppingRouteList.get(i);
        	galileoShoppingRoute.setLastUpdateDateTime(System.currentTimeMillis());
        	galileoShoppingRoute.setId(startId);
        	//galileoShoppingRoute.setSeqNo(startSeqNo);
        	galileoShoppingRoute.setQueryKey(queryKey);
        }
        
        List<CacheData> datas = new ArrayList<CacheData>();

		List<String> routeKeys = new ArrayList<>();
		long time = 0;
		for (GalileoShoppingRoute r : galileoShoppingRouteList) {
			if (time == 0) {
				time = new DateTime(r.getGalileoShoppingProcessList().get(0).getFromDate()).toDate().getTime();
			}
			CacheData d = new CacheData(r.getRouteKey(), r.getId(), SerializeUtils.Tserialize(r));
			routeKeys.add(r.getRouteKey());
			datas.add(d);
		}
		CacheOpt opt = new CacheOpt(queryKey, datas, null);
		cacheChannel.write(opt);
		timeDataChannel.write(time, routeKeys);
	} else {
		CacheOpt opt = new CacheOpt(queryKey, (new ErrorMsg(error.getErrorCode(), error.getErrorMsg())));
		cacheChannel.write(opt);
	}
        
    }
    
}

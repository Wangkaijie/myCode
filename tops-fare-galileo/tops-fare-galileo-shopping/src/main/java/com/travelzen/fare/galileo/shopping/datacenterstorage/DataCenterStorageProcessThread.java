package com.travelzen.fare.galileo.shopping.datacenterstorage;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.travelzen.fare.datacenter.storage.DataCenterRecord;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.route.channel.GalileoShoppingRouteWriteFactory;
import com.travelzen.fare.galileo.shopping.util.GalileoKeyUtils;
import com.travelzen.fare.util.common.channel.ChannelWriteData;
import com.travelzen.fare.util.common.channel.ChannelWriteData.ErrorInfo;
import com.travelzen.fare.util.common.queue.FareQueue;
import com.travelzen.flight.api.galileo.pojo.SearchResult;
import com.travelzen.framework.logger.core.ri.RequestIdentityHolder;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class DataCenterStorageProcessThread extends Thread{
private static Logger logger = RequestIdentityLogger.getLogger(DataCenterStorageProcessThread.class);
    
    private FareQueue<DataCenterRecord> dataCenterStorageTableQueue = null;
    
    private DataCenterStorageProcessThread(FareQueue<DataCenterRecord> dataCenterStorageTableQueue) {
    	this.dataCenterStorageTableQueue = dataCenterStorageTableQueue;
    }
    
    public static void startTask(FareQueue<DataCenterRecord> dataCenterStorageTableQueue) {
    	DataCenterStorageProcessThread thread = new DataCenterStorageProcessThread(dataCenterStorageTableQueue);
    	thread.start();
    }

    @Override
    public void run() {
    	
    	logger.info("Galileo同步数据开始");
    	
    	String queryKey = null;
    	
    	GalileoShoppingRequest galileoShoppingRequest = null;
    	GalileoShoppingResponse galileoShoppingResponse = null;
    	
    	DataCenterRecord dataCenterRecord = null;
    	SearchResult searchResult = null;
    	
    	long start = System.currentTimeMillis();
    	    	
    	
        while (true) {
            try {
            	dataCenterRecord = dataCenterStorageTableQueue.acquire();
                if (dataCenterRecord == null) {
                	continue;
                }
            
                
                //TimeStampUtil timeStamp = new TimeStampUtil();
                RequestIdentityHolder.init();
                
               // timeStamp.start();
                galileoShoppingRequest = DataCenterStorageConvertor.dataCenterStorageTableToGalileoShoppingRequestConvertor(dataCenterRecord);
               logger.info("同步数据, galileoShoppingRequest: "+galileoShoppingRequest);
                if (galileoShoppingRequest == null) {
                    logger.error("错误galileoShoppingRequest:" + JSON.toJSONString(dataCenterRecord, true));
                    continue;
                }
                
                galileoShoppingResponse = new GalileoShoppingResponse();
                queryKey = GalileoKeyUtils.galileoShoppingRequest2QueryKey(galileoShoppingRequest);
                logger.info("Galileo同步数据的queryKey为："+queryKey);
                galileoShoppingResponse.setQueryKey(queryKey);
                
               if (dataCenterRecord.isSetData()) {
            	   searchResult = new Gson().fromJson(dataCenterRecord.getData(), SearchResult.class);
            	   if (searchResult==null) {
            		   logger.error("searchResult 为 null："+ JSON.toJSONString(dataCenterRecord));
                    	continue;
            	   }
               }
               
                try{
                	galileoShoppingResponse=GalileoShoppingParser.searchResultToGalileoShoppingResponse(searchResult, galileoShoppingResponse);
                	logger.info("同步解析耗时："+(System.currentTimeMillis()-start));
                	saveRouteList(queryKey, galileoShoppingResponse);
                }catch (Exception e) {
                    logger.error("Process:" + e.getMessage(), e);
                }
            } catch (Exception e) {
                logger.error("Process:" + e.getMessage(), e);
            }
        }
    }
    
    private static void saveRouteList(String queryKey, GalileoShoppingResponse galileoShoppingResponse) {
    	if (galileoShoppingResponse == null) {
    		return ;
    	}
    	
        try {
            if (galileoShoppingResponse.isSetGalileoShoppingRouteList() && galileoShoppingResponse.getGalileoShoppingRouteList().size() > 0) {
            	galileoShoppingResponse.setQueryKey( galileoShoppingResponse.getQueryKey());

            	GalileoShoppingRouteWriteFactory.saveRouteList(queryKey, galileoShoppingResponse.getGalileoShoppingRouteList());
            } else if (galileoShoppingResponse.getError() != null) {
            	  ErrorInfo error=new ErrorInfo();
                  ChannelWriteData channelWriteData = new ChannelWriteData();
      			  error.setErrorCode(galileoShoppingResponse.getError().getErrorCode());
      			  error.setErrorMsg(galileoShoppingResponse.getError().getErrorMsg());
      			  channelWriteData.setErrorInfo(error);
            }
        } catch (Exception e) {
            logger.error("save route error:" + e.getMessage(), e);
        }
    }

}

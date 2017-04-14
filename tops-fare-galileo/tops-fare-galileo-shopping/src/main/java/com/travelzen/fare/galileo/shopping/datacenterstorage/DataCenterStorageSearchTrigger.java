package com.travelzen.fare.galileo.shopping.datacenterstorage;

import org.slf4j.Logger;

import com.travelzen.fare.datacenter.common.GDSCommandEnum;
import com.travelzen.fare.datacenter.storage.DataCenterRecord;
import com.travelzen.fare.datacenter.storage.client.util.DataCenterStorageClientUtil;
import com.travelzen.fare.datacenter.storage.service.DataCenterStorageResult;
import com.travelzen.fare.datacenter.strategy.DataCenterStrategyTable;
import com.travelzen.fare.galileo.shopping.config.DataCenterStorageTrigger;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.util.GalileoKeyUtils;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class DataCenterStorageSearchTrigger {
	
private static Logger logger = RequestIdentityLogger.getLogger(DataCenterStorageSearchTrigger.class);
    
    private static final long VALIDY_PERIOD = DataCenterStorageTrigger.getShoppingTriggerConf();
    
    public static void shoppingStorageSearchTrigger(GalileoShoppingRequest req) throws Exception {
        logger.info("Galileoshopping  Storage Search   Trigger");
        String queryKey=GalileoKeyUtils.galileoShoppingRequest2QueryKey(req);
        DataCenterStrategyTable dataCenterStrategyTable = DataCenterStorageConvertor.galileoShoppingRequestToDataCenterStrategyTableConvertor(req);
        DataCenterStorageResult dataCenterStorageResult = DataCenterStorageClientUtil.getClientInstance(GDSCommandEnum.GalileoShopping)
                .getDataCenterStorageTable(dataCenterStrategyTable, VALIDY_PERIOD);
        if (dataCenterStorageResult.isSetDataCenterRecord() == false) {
            DataCenterStorageClientUtil.getClientInstance(GDSCommandEnum.GalileoShopping).triggerDataCenterStrategy(
                    dataCenterStrategyTable);
            logger.info("Galileoshopping  Storage Search   Trigger Start .queryKey="+queryKey);
        }else{
        	DataCenterRecord record=dataCenterStorageResult.getDataCenterRecord();
        	if("999".equals(record.getErrorInfo().getErrorCode())){
        		 DataCenterStorageClientUtil.getClientInstance(GDSCommandEnum.GalileoShopping).triggerDataCenterStrategy(
                         dataCenterStrategyTable);
                 logger.info("Galileoshopping  Storage Search   Trigger Start");
        	}else{
        		logger.info(queryKey+"not need Trigger the seqNo="+record.getSeqNo());
        	}
        }
    }

}

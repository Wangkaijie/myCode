package com.travelzen.fare.galileo.shopping.datacenterstorage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.google.gson.Gson;
import com.travelzen.fare.datacenter.storage.DataCenterRecord;
import com.travelzen.fare.datacenter.strategy.DataCenterStrategyBasicInfo;
import com.travelzen.fare.datacenter.strategy.DataCenterStrategyEnum;
import com.travelzen.fare.datacenter.strategy.DataCenterStrategyTable;
import com.travelzen.fare.datacenter.strategy.shopping.DataCenterStrategyGalileoShopping;
import com.travelzen.fare.galileo.convertor.request.GalileoShoppingRequestToSearchRequestConvertor;
import com.travelzen.fare.galileo.convertor.request.SearchRequestToGalileoShoppingRequestConvertor;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.flight.api.galileo.pojo.SearchRequest;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class DataCenterStorageConvertor {
	
private static Logger logger = RequestIdentityLogger.getLogger(DataCenterStorageConvertor.class);
	
	public static DataCenterStrategyTable galileoShoppingRequestToDataCenterStrategyTableConvertor(GalileoShoppingRequest req) throws Exception {
        DataCenterStrategyTable dataCenterStrategyTable = null;
        DataCenterStrategyBasicInfo dataCenterStrategyBasicInfo = null;
        DataCenterStrategyGalileoShopping dataCenterStrategyGalileoShopping = null;
        
        dataCenterStrategyTable = new DataCenterStrategyTable();
        dataCenterStrategyTable.setDataCenterStrategyEnum(DataCenterStrategyEnum.Release);
        
        dataCenterStrategyBasicInfo = new DataCenterStrategyBasicInfo();
        dataCenterStrategyBasicInfo.setLastUpdateUser("webService");
        dataCenterStrategyBasicInfo.setFromType("webService");
        dataCenterStrategyBasicInfo.setExecDuration(0l);
        dataCenterStrategyBasicInfo.setLastExecTime(0l);
        dataCenterStrategyTable.setDataCenterStrategyBasicInfo(dataCenterStrategyBasicInfo);
        
        dataCenterStrategyGalileoShopping = new DataCenterStrategyGalileoShopping();
        dataCenterStrategyGalileoShopping.setKey(new Gson().toJson(GalileoShoppingRequestToSearchRequestConvertor.galileoShoppingRequestToSearchRequest(req)));
        dataCenterStrategyTable.setDataCenterStrategyGalileoShopping(dataCenterStrategyGalileoShopping);
        logger.info("dataCenterStrategyTable: "+dataCenterStrategyTable);
        return dataCenterStrategyTable;
    }
	
	
	public static GalileoShoppingRequest dataCenterStorageTableToGalileoShoppingRequestConvertor(DataCenterRecord dataCenterRecord) throws Exception {
        if (!dataCenterRecord.isSetData() || StringUtils.isBlank(dataCenterRecord.getRequest())) {
            return null;
        }
        
        GalileoShoppingRequest galileoShoppingRequest = null;
        SearchRequest searchRequest = null;
        
        searchRequest = new Gson().fromJson(dataCenterRecord.getRequest(), SearchRequest.class);
        galileoShoppingRequest = SearchRequestToGalileoShoppingRequestConvertor.searchRequestToGalileoShoppingRequest(searchRequest);

        return galileoShoppingRequest;
    }

}

package com.travelzen.fare.galileo.shopping.farerule.search;

import java.util.UUID;

import org.slf4j.Logger;

import com.google.gson.Gson;
import com.travelzen.fare.galileo.convertor.farerule.GalileoVerifyFareRuleToGalileoDisplayFareRuleConvertor;
import com.travelzen.fare.galileo.shopping.db.dao.GalileoShoppingFareRuleDao;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.fare.galileo.shopping.util.GalileoKeyUtils;
import com.travelzen.flight.FlightClient;
import com.travelzen.flight.api.galileo.bean.GalileoResponse;
import com.travelzen.flight.api.galileo.pojo.ItineraryPricing;
import com.travelzen.flight.api.galileo.pojo.ItineraryPricingRequest;
import com.travelzen.flight.api.galileo.pojo.ItineraryPricingResponse;
import com.travelzen.flight.api.galileo.pojo.ItineraryPricingResult;
import com.travelzen.flight.api.utils.GalileoXmlDataFilter;
import com.travelzen.flight.api.utils.XmlConvert;
import com.travelzen.framework.logger.core.ri.CallInfo;
import com.travelzen.framework.logger.core.ri.RequestIdentityHolder;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class SearchGalileoShoppingFareRuleTask implements Runnable{
	private static Logger logger = RequestIdentityLogger.getLogger(SearchGalileoShoppingFareRuleTask.class);
	
private String galileoFareRuleId;
	
	public SearchGalileoShoppingFareRuleTask(String galileoFareRuleId, CallInfo callInfo){
		this.galileoFareRuleId = galileoFareRuleId;
		if(null != callInfo){
			RequestIdentityHolder.set(callInfo);
		}
	}

	@Override
	public void run() {
		
		GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule = null;
		GalileoResponse galileoResponse = null;
		 XmlConvert xmlConvert = null;
		 ItineraryPricingResponse itineraryPricingResponse = null;
		 ItineraryPricingResult itineraryPricingResult = null;

		long startSearchTime=System.currentTimeMillis();
		long endSearchTime=System.currentTimeMillis();
		long endSaveToDBTime=System.currentTimeMillis();
		
		FlightClient flightClient = FlightClient.getInstance();
		xmlConvert = new XmlConvert(new GalileoXmlDataFilter());
        galileoResponse = flightClient.getGalileoTravelAgentService().galileoItineraryPricing(UUID.randomUUID().toString(), galileoFareRuleId);
        itineraryPricingResponse = xmlConvert.decode(galileoResponse.getValue(), ItineraryPricingResponse.class);
        itineraryPricingResult = itineraryPricingResponse.getItineraryPricingResult();

		//转换退改签
		try{
			galileoShoppingDisplayFareRule=GalileoVerifyFareRuleToGalileoDisplayFareRuleConvertor.fromGalileoVerifyFareRule(itineraryPricingResult.getRule());
			galileoShoppingDisplayFareRule.setLastUpdateTime(System.currentTimeMillis());
			galileoShoppingDisplayFareRule.setId(GalileoKeyUtils.key2Md5(galileoFareRuleId));
			logger.info("galileoShoppingDisplayFareRule.id :"+galileoShoppingDisplayFareRule.getId());
		}catch(Exception e){
			logger.error("in SearchgalileoShoppingFareRuleTask,转换异常为："+e.getMessage());
		}
		
		//存储到数据库
		try{
			GalileoShoppingFareRuleDao.saveFareRule(galileoShoppingDisplayFareRule);
		}catch(Exception e){
			logger.error("in SearchGalileoShoppingFareRuleTask,存储数据库异常为："+e.getMessage());
		}
		endSaveToDBTime=System.currentTimeMillis();
		
		logger.info("伽利略退改签查询耗时："+(endSearchTime-startSearchTime)+"伽利略退改签存储到数据库耗时："+(endSaveToDBTime-endSearchTime));
		
	}

}

package com.travelzen.fare.galileo.shopping.farerule.search;

import org.slf4j.Logger;

import com.travelzen.fare.galileo.shopping.db.dao.GalileoShoppingFareRuleDao;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.fare.galileo.shopping.util.GalileoKeyUtils;
import com.travelzen.framework.logger.core.ri.RequestIdentityHolder;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.framework.metrics.MetricsMonitor;
import com.travelzen.framework.metrics.MetricsMonitorFactory;

public class GalileoShoppingFareRuleSearchHandler {
	
	private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingFareRuleSearchHandler.class);
	private static MetricsMonitor fareRuleMetricsMonitor = MetricsMonitorFactory.getMonitor("GalileoShoppingFareRuleSearchHandler");
	
	public static GalileoShoppingDisplayFareRule searchGalileoShoppingFareRule(String galileoFareRuleId){
		
		long startTime=System.currentTimeMillis();
		GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule=null;
		if(null == galileoFareRuleId && galileoFareRuleId.equals("")){
			logger.info("galileoFareRuleId is null");
			return null;
		}
		
	    galileoShoppingDisplayFareRule= searchFareRuleFromGalileoGDS(galileoFareRuleId);
	    if(null != galileoShoppingDisplayFareRule){
	    	logger.info("galileoShoppingDisplayFareRule: "+galileoShoppingDisplayFareRule);
	    	return galileoShoppingDisplayFareRule;
	    }else{
	    	logger.info("galileoShoppingDisplayFareRule 为null");
	    }
		logger.info("galileo退改签查询结束");
		
	return null;
	}
	
	protected static GalileoShoppingDisplayFareRule searchFareRuleFromGalileoGDS(String galileoFareRuleId){
		long beginQueryTime = 0l;
		
		String galileoFareRuleQueryMD5 = null;
		
		GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule = null;
		
		beginQueryTime = System.currentTimeMillis();
		
		if(null != galileoFareRuleId && galileoFareRuleId.equals("") == false){
			galileoFareRuleQueryMD5 = GalileoKeyUtils.key2Md5(galileoFareRuleId);
			try{
				galileoShoppingDisplayFareRule = GalileoShoppingFareRuleDao.searchGalileoFareRuleInfoById(galileoFareRuleQueryMD5);
			}catch(Exception e){
				logger.info(e.getMessage());		
				}
			if(null != galileoShoppingDisplayFareRule){
				fareRuleMetricsMonitor.count(1, "galileo farerule from db");
				return galileoShoppingDisplayFareRule;
			}else{
				logger.info("数据库查询的伽利略退改签为null");
				GalileoShoppingFareRuleSearchThreadController.getExecutor().submit(new SearchGalileoShoppingFareRuleTask(galileoFareRuleId,RequestIdentityHolder.get()));
			}
		}
			while (true){
				long timeWait=System.currentTimeMillis() - beginQueryTime;
				
				if (timeWait >= 8 * 1000){
					fareRuleMetricsMonitor.count(1, "galileo farerule 超时");
					logger.info("伽利略退改签查询超时");
					break;
				}
				
				try{
					Thread.sleep(1000);
					
					galileoShoppingDisplayFareRule = GalileoShoppingFareRuleDao.searchGalileoFareRuleInfoById(galileoFareRuleQueryMD5);
					if(null != galileoShoppingDisplayFareRule){
						fareRuleMetricsMonitor.count(1, "galileo farerule from GDS");
						logger.info("返回的伽利略退改签为："+galileoShoppingDisplayFareRule);
						return galileoShoppingDisplayFareRule;
					}
				}catch(Exception e){
					logger.error(e.getMessage(), e);
				}

			}
		
		return galileoShoppingDisplayFareRule;
	}

}

package com.travelzen.fare.galileo.shopping.handler;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;

import com.codahale.metrics.Timer;
import com.travelzen.fare.datacenter.common.GDSCommandEnum;
import com.travelzen.fare.datacenter.storage.client.util.DataCenterStorageClientUtil;
import com.travelzen.fare.datacenter.strategy.DataCenterStrategyTable;
import com.travelzen.fare.galileo.shopping.datacenterstorage.DataCenterStorageConvertor;
import com.travelzen.fare.galileo.shopping.db.dao.GalileoShoppingRouteDao;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.fare.galileo.shopping.farerule.search.GalileoShoppingFareRuleSearchHandler;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.framework.metrics.MetricsMonitor;
import com.travelzen.framework.metrics.MetricsMonitorFactory;
import com.travelzen.fare.galileo.shopping.service.GalileoShoppingService;
import com.travelzen.fare.galileo.shopping.util.GalileoShoppingExchangeRateUtil;

public class GalileoShoppingServiceImpl implements GalileoShoppingService.Iface{
	
	private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingServiceImpl.class);
	 private MetricsMonitor monitor = MetricsMonitorFactory.getMonitor("GalileoShoppingServiceImpl");

	@Override
	public GalileoShoppingResponse galileoFareSearch(GalileoShoppingRequest request)
			throws TException {
		Timer.Context context = monitor.timer("galileoFareSearch");
		if(request.isSetTripType() == false ){
			return null;
		}
		
		GalileoShoppingResponse galileoShoppingResponse = null;

		long begin=System.currentTimeMillis();
        
        try {
        	galileoShoppingResponse = GalileoShoppingSearchHandler.fareSearch(request);
        	logger.info("in galileoFareSearch, galileoShoppingResponse为："+galileoShoppingResponse);
        } catch (Exception e) {
			throw new TException(e);
        }finally{
        	context.stop();
        }

        logger.info("galileoFareSearch 耗时 = "+(System.currentTimeMillis()-begin));

		if(galileoShoppingResponse!=null&&galileoShoppingResponse.getError()!=null){
			logger.info("galileoFareSearch error result = "+galileoShoppingResponse);
		}

        return galileoShoppingResponse;
	}

	@Override
	public GalileoShoppingDisplayFareRule galileoGetFareRule(String id)
			throws TException {
		Timer.Context context = monitor.timer("galileoGetFareRule");
		GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule=new GalileoShoppingDisplayFareRule();
		galileoShoppingDisplayFareRule.setEndorse("具体的退改签规则请以航空公司审核为准，更改及退票加收60港币/张的服务费");
		galileoShoppingDisplayFareRule.setId("0");
		context.stop();
		return galileoShoppingDisplayFareRule;
	}

	@Override
	public GalileoShoppingRoute galileoGetRouteFromDB(String id)
			throws TException {
		Timer.Context context = monitor.timer("galileoGetRouteFromDB");
		GalileoShoppingRoute galileoShoppingRoute= null;
        
		try {
			logger.info("in galileoGetRouteFromDB, id:"+id);
			galileoShoppingRoute = GalileoShoppingCheckHandler.galileoGetRouteFromDB(id);
			logger.info("in galileoGetRouteFromDB, 返回的galileoShoppingRoute："+galileoShoppingRoute);
		} catch (Exception e) {
			throw new TException(e);
		}finally{
			context.stop();
		}
        
        return galileoShoppingRoute;
	}

	@Override
	public List<GalileoShoppingRoute> galileoGetRouteFromDBByRouteKey(
			String routeKey) throws TException {
		Timer.Context context = monitor.timer("galileoGetRouteFromDBByRouteKey");
		List<GalileoShoppingRoute> galileoShoppingRouteList = null;
        
		try {
			logger.info("in galileoGetRouteFromDB, routeKey :"+routeKey);
			galileoShoppingRouteList = GalileoShoppingCheckHandler.galileoGetRouteFromDBByRouteKey(routeKey);
			
			galileoShoppingRouteList = GalileoShoppingExchangeRateUtil.computeCNY(galileoShoppingRouteList);
			
			logger.info("in galileoGetRouteFromDB, 返回的galileoShoppingRouteList："+galileoShoppingRouteList);
		} catch (Exception e) {
			throw new TException(e);
		}finally{
			context.stop();
		}
        
        return galileoShoppingRouteList;
	}

	@Override
	public boolean refreshCacheByRouteKey(String routeKey, GalileoShoppingRequest req) throws TException {
		GalileoShoppingRouteDao.deleteByRouteKey(routeKey);
		DataCenterStrategyTable dataCenterStrategyTable;
		try {
			dataCenterStrategyTable = DataCenterStorageConvertor.galileoShoppingRequestToDataCenterStrategyTableConvertor(req);
			DataCenterStorageClientUtil.getClientInstance(GDSCommandEnum.GalileoShopping).triggerDataCenterStrategy(
	                dataCenterStrategyTable);
		} catch (Exception e) {
			logger.error("refreshCacheByRouteKey trigger Exception: ",e);

		}
        
        return true;
	}

	@Override
	public boolean refreshCacheByRouteId(long routeId, GalileoShoppingRequest req) throws TException {
		GalileoShoppingRouteDao.deleteByRouteId(routeId);
		DataCenterStrategyTable dataCenterStrategyTable;
		try {
			dataCenterStrategyTable = DataCenterStorageConvertor.galileoShoppingRequestToDataCenterStrategyTableConvertor(req);
			DataCenterStorageClientUtil.getClientInstance(GDSCommandEnum.GalileoShopping).triggerDataCenterStrategy(
	                dataCenterStrategyTable);
		} catch (Exception e) {
			logger.error("refreshCacheByRouteKey trigger Exception: ",e);

		}
        
        return true;
	}

}

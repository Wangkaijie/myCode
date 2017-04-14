package com.travelzen.fare.galileo.shopping.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.datacenterstorage.DataCenterStorageSearchTrigger;
import com.travelzen.fare.galileo.shopping.db.dao.GalileoShoppingRouteDao;
import com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable;
import com.travelzen.fare.galileo.shopping.filter.GalileoShoppingFilter;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponseStatusEnum;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.fare.galileo.shopping.util.GalileoKeyUtils;
import com.travelzen.fare.galileo.shopping.util.GalileoShoppingExchangeRateUtil;
import com.travelzen.fare.galileo.shopping.util.GalileoShoppingTimeUtil;
import com.travelzen.fare.galileo.shopping.util.GalileoShoppingUtil;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.framework.metrics.MetricsMonitor;
import com.travelzen.framework.metrics.MetricsMonitorFactory;
import com.travelzen.framework.util.DateUtils;

public class GalileoShoppingSearchHandler {
	
private static MetricsMonitor searchMetricsMonitor = MetricsMonitorFactory.getMonitor("GalileoShoppingSearchHandler");
	
	private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingSearchHandler.class);

    public static GalileoShoppingResponse fareSearch(GalileoShoppingRequest galileoShoppingRequest) throws Exception {
    	GalileoShoppingResponse galileoShoppingResponse = null;
        
        long startRequestTime;
        long timeWait;
        boolean fromDB;
        
        if (null==galileoShoppingRequest.getPassengerTypeSet() || galileoShoppingRequest.getPassengerTypeSet().size() <=0){
        	Set<GalileoPassengerType> galileoPassengerTypeSet = new HashSet<GalileoPassengerType>();
        	galileoPassengerTypeSet.add(GalileoPassengerType.ADT);
        	galileoShoppingRequest.setPassengerTypeSet(galileoPassengerTypeSet);
        }
        
        startRequestTime = System.currentTimeMillis();// 任务开始时间
        fromDB = true;
        
        logger.info("galileoShoppingRequest:"+galileoShoppingRequest.toString());
        
        galileoShoppingResponse = searchFromDB(galileoShoppingRequest, startRequestTime);
        
        // 判断是否需要触发
        if(GalileoShoppingUtil.isEmpty(galileoShoppingResponse)||GalileoShoppingUtil.isNotFresh(galileoShoppingResponse)){
        	DataCenterStorageSearchTrigger.shoppingStorageSearchTrigger(galileoShoppingRequest);
        }
        // 不断检索数据库获取查询结果
        long wt=30*1000;
        if (galileoShoppingResponse.getGalileoShoppingResponseStatusEnum()!=GalileoShoppingResponseStatusEnum.InValid) {
        	 wt=15*1000;
		}
        while (true) {
        	if(GalileoShoppingUtil.isBreak(galileoShoppingResponse)){
        		
        		break;
        	}
        	
            fromDB = false;
            timeWait = System.currentTimeMillis() - startRequestTime;
            if (timeWait > wt) {
            	searchMetricsMonitor.count(1, "galileo search 超时");
            	if (galileoShoppingResponse != null && galileoShoppingResponse.isSetError() == false) {
            		GalileoShoppingErrorTable error=new GalileoShoppingErrorTable();
            		error.setErrorCode("201");
            		error.setErrorMsg("任务超时");
            		galileoShoppingResponse.setError(error);
            	}
                break;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
            
            galileoShoppingResponse = searchFromDB(galileoShoppingRequest, startRequestTime);
        }
        
        logger.info("in galileoShopping: fareSearch, total searchFromDB sepend:" + (System.currentTimeMillis() - startRequestTime));
        if (galileoShoppingResponse == null) {
        	galileoShoppingResponse = new GalileoShoppingResponse();
        	GalileoShoppingErrorTable error=new GalileoShoppingErrorTable();
    		error.setErrorCode("201");
    		error.setErrorMsg("任务超时");
    		galileoShoppingResponse.setError(error);
            return galileoShoppingResponse;
        } 
        
        if (galileoShoppingResponse != null && galileoShoppingResponse.isSetError() == true) {
        	searchMetricsMonitor.count(1, "galileo search error");
    		logger.error(galileoShoppingResponse.getQueryKey() + ":" + galileoShoppingResponse.getError().getErrorMsg());
    	}
        
        if (fromDB) {
        	searchMetricsMonitor.count(1, "galileo search fromDB");
        	galileoShoppingResponse.setSearchSource("Cache");
        } else {
        	searchMetricsMonitor.count(1, "galileo search from GDS");
        	galileoShoppingResponse.setSearchSource("GDS");
        }
        
        GalileoShoppingFilter.doFilter(galileoShoppingResponse, galileoShoppingRequest.getPassengerTypeSet());
       //过滤舱等
       // logger.info("galileoShoppingRequest－－－－－"+galileoShoppingRequest);
        //logger.info("过滤前的galileoShoppingResponse为："+galileoShoppingResponse);
        galileoShoppingResponse= GalileoShoppingFilter.doFilterCabinclass(galileoShoppingResponse, galileoShoppingRequest);
        galileoShoppingResponse = GalileoShoppingExchangeRateUtil.computeCNY(galileoShoppingResponse);
      // logger.info("过滤后的galileoShoppingResponse为："+galileoShoppingResponse);
        return galileoShoppingResponse;
    }
    
    private static GalileoShoppingResponse searchFromDB(GalileoShoppingRequest galileoShoppingRequest, long firstRequestTime) throws Exception {
    	logger.info(String.format("Begin searchFromDB(%s,%s)",galileoShoppingRequest,firstRequestTime));
    	String queryKey = null;
    	
    	
    	GalileoShoppingResponse galileoShoppingResponse = null;
    	
    	queryKey = GalileoKeyUtils.galileoShoppingRequest2QueryKey(galileoShoppingRequest);
    	
    	logger.info("galileo queryKey: "+queryKey );
        
    	galileoShoppingResponse = GalileoShoppingRouteDao.getRoutesByQueryKey(queryKey);
    	if (galileoShoppingResponse==null) {
    		galileoShoppingResponse=new GalileoShoppingResponse();
    		galileoShoppingResponse.setQueryKey(queryKey);
    		return galileoShoppingResponse;	
		}
    	
    	if (!galileoShoppingResponse.isSetError()) {
    		galileoShoppingResponse = genGalileoShoppingResponse(firstRequestTime, galileoShoppingResponse);
		}

        if (galileoShoppingResponse != null) {
        	galileoShoppingResponse.setQueryKey(queryKey);
        }
        
        return galileoShoppingResponse;
    }
    
    
    private static GalileoShoppingResponse genGalileoShoppingResponse(long firstRequestTime, 
    		GalileoShoppingResponse galileoShoppingResponse) {
    	int i;
    	GalileoShoppingResponse galileoShoppingResponseFh=new GalileoShoppingResponse();
    	GalileoShoppingRoute galileoShoppingRoute = null;
    	List<GalileoShoppingRoute> galileoShoppingRouteListRS = new ArrayList<GalileoShoppingRoute>();
    	
    	
    	if (galileoShoppingResponse.getGalileoShoppingRouteList() == null || galileoShoppingResponse.getGalileoShoppingRouteList().size() <= 0) {
    		GalileoShoppingErrorTable galileoShoppingErrorTable=new GalileoShoppingErrorTable();
    		galileoShoppingErrorTable.setErrorCode("201");
    		galileoShoppingErrorTable.setErrorMsg("没有查询到数据");
    		galileoShoppingResponseFh.setError(galileoShoppingErrorTable);
    		return galileoShoppingResponseFh;
    	}
    	
    	long departureDateTime=0;
    	long lastUpdateTime=0;
    	for ( i = 0; i < galileoShoppingResponse.getGalileoShoppingRouteList().size(); i++) {
    		galileoShoppingRoute=galileoShoppingResponse.getGalileoShoppingRouteList().get(i);
    		
    		if (departureDateTime==0) {
    			departureDateTime=getDepartureDateTime(galileoShoppingRoute);	
			}
			
    		if (lastUpdateTime==0) {
    			lastUpdateTime=galileoShoppingRoute.getLastUpdateDateTime();
			}
    		galileoShoppingRouteListRS.add(galileoShoppingRoute);
		}
    	galileoShoppingResponseFh.setGalileoShoppingRouteList(galileoShoppingRouteListRS);
    	galileoShoppingResponseFh.setGalileoShoppingResponseStatusEnum(GalileoShoppingTimeUtil.getStatuEnum(lastUpdateTime,departureDateTime));
    	
        return galileoShoppingResponseFh;
    }

	private static long getDepartureDateTime(
			GalileoShoppingRoute galileoShoppingRoute) {
		String date=galileoShoppingRoute.getGalileoShoppingProcessList().get(0).getFromDate();
		String time=galileoShoppingRoute.getGalileoShoppingProcessList().get(0).getFromTime();
		 
		if(!StringUtils.isBlank(date)&&!StringUtils.isBlank(time)){
			String dateTime=date+" "+time+":00";
			return DateUtils.getDate(dateTime, null).getTime();
		}
		
		return 0;
	}

}

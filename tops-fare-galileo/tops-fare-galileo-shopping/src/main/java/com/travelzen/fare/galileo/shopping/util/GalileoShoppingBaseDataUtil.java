package com.travelzen.fare.galileo.shopping.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;
import com.travelzen.fare.basic.data.cabinshopping.requestresponse.CabinShoppingRequest;
import com.travelzen.fare.basic.data.cabinshopping.requestresponse.CabinShoppingResponse;
import com.travelzen.fare.basic.data.shopping.client.util.BasicDataShoppingClientUtil;
import com.travelzen.fare.galileo.shopping.datacenterstorage.GalileoShoppingParser;
import com.travelzen.fare.galileo.shopping.flight.GalileoShoppingFlight;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingProcess;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.tops.flight.cache.CabinDiscountCache;
import com.travelzen.tops.flight.cache.FlightCityCache;
import com.travelzen.tops.flight.common.base.entity.CityCode;

public class GalileoShoppingBaseDataUtil {
	private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingBaseDataUtil.class);
	public static String getCityOfAirport(String airportCode){
    	FlightCityCache.getInstance();
    	CityCode cityCode = FlightCityCache.getCityByAirPortCode(airportCode);
    	if(null == airportCode || airportCode.equals("")){
    		return "";
    	}
    	
    	return cityCode.getCityCode();
    }
    
    
	   public static String getCabinClassOfCabin(String airCompany, String cabin,String fromDate, String subCabinCode){
	    	CabinDiscountCache.getInstance();
	    	
	    	return CabinDiscountCache.getCabinLevel(airCompany, cabin, fromDate,subCabinCode);

	    }
    
	   //通过基础数据getCabinClass
	   public static void getgetCabinClass(List<GalileoShoppingRoute> galileoShoppingRoutes) throws TException, Exception{
		   
		   if (galileoShoppingRoutes.size()>0) {
			CabinShoppingRequest cabinShoppingRequest=null;
			List<CabinShoppingResponse> cabinShoppingResponses=null;
			List<CabinShoppingRequest> cabinShoppingRequests=new ArrayList<CabinShoppingRequest>();
			   for (GalileoShoppingRoute route:galileoShoppingRoutes) {
				for (GalileoShoppingProcess process: route.getGalileoShoppingProcessList()) {
					for (GalileoShoppingFlight flight:process.getGalileoShoppingFlightList()) {
						 cabinShoppingRequest=new CabinShoppingRequest();
						 cabinShoppingRequest.setAirline(flight.getCarrier());
			       		 cabinShoppingRequest.setCabin(flight.getBookingClass());
			       		 cabinShoppingRequests.add(cabinShoppingRequest);
					}
				}
			}
			   cabinShoppingResponses=BasicDataShoppingClientUtil.getClientInstance().getCabinList(cabinShoppingRequests);
			   if (cabinShoppingResponses!=null) {
			   int j=0;
			   for (GalileoShoppingRoute route:galileoShoppingRoutes) {
					for (GalileoShoppingProcess process: route.getGalileoShoppingProcessList()) {
			   		for(int i=0;i<process.getGalileoShoppingFlightList().size();i++){
			   			if(cabinShoppingResponses.get(j).isSetCabinShoppingCabinRoute()){
			   				
			   				process.getGalileoShoppingFlightList().get(i).setCabinClass(cabinShoppingResponses.get(j).getCabinShoppingCabinRoute().getBasicDataCabin());	
			   			
			   			}else {
			   				logger.info("没有获取到该航司的舱位："+cabinShoppingResponses.get(j).getCabinshoppingErorTable().getErrorMsg());
						}
		                j++;
			   		}
			   		
		   		}
			  }
			}
		}
	   }
	   
    
    public static void main(String[] args){
    	System.out.println(getCityOfAirport("HKG"));
    	System.out.println(getCabinClassOfCabin("CA","H","2016-03-26",""));
    }

}

package com.travelzen.fare.galileo.shopping.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.flight.GalileoShoppingFlight;
import com.travelzen.fare.galileo.shopping.handler.AirCompanyFilter;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingProcess;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
public class GalileoShoppingFilter {
	public static GalileoShoppingResponse doFilter(GalileoShoppingResponse galileoShoppingResponse, Set<GalileoPassengerType> passengerTypeSet)throws Exception{
		if(null == galileoShoppingResponse || galileoShoppingResponse.isSetGalileoShoppingRouteList() == false ||
				galileoShoppingResponse.getGalileoShoppingRouteListSize() < 0){
			return galileoShoppingResponse;
		}
		
		int i;
		
		GalileoShoppingRoute galileoShoppingRoute = null;
		List<GalileoShoppingRoute> galileoShoppingRouteList = new ArrayList<GalileoShoppingRoute>();
		
		for (i = 0; i < galileoShoppingResponse.getGalileoShoppingRouteList().size(); ++i) {
			galileoShoppingRoute = galileoShoppingResponse.getGalileoShoppingRouteList().get(i);
			
			//过滤乘客类型 && 过滤配置文件
			if (null != passengerTypeSet && passengerTypeSet.contains(galileoShoppingRoute.getPassengerType()) && !isContainCertainAirCompany(galileoShoppingRoute)){
				galileoShoppingRouteList.add(galileoShoppingRoute);
			}
			
		}
		
	
		galileoShoppingResponse.setGalileoShoppingRouteList(galileoShoppingRouteList);
		return galileoShoppingResponse;
		
	}
	
	
	private static boolean isContainCertainAirCompany(GalileoShoppingRoute galileoShoppingRoute)throws Exception{
		
		for(GalileoShoppingProcess galileoShoppingProcess: galileoShoppingRoute.getGalileoShoppingProcessList()){
			for(GalileoShoppingFlight galileoShoppingFlight : galileoShoppingProcess.getGalileoShoppingFlightList()){
				if(AirCompanyFilter.isContainAirCompany(galileoShoppingFlight.getCarrier())){
					return true;
				}
			}
		}
		
		return false;
	}

	public static GalileoShoppingResponse  doFilterCabinclass(GalileoShoppingResponse galileoShoppingResponse,GalileoShoppingRequest galileoShoppingRequest){
		GalileoShoppingResponse response=null;
		List<GalileoShoppingRoute> galileoShoppingRoutes=null;
		int cabinNo=0;
		int flightCabinClass=0;
		if (galileoShoppingRequest.getCabinType()==null) {
			return galileoShoppingResponse;
		}
		response =new GalileoShoppingResponse();
		galileoShoppingRoutes=new ArrayList<GalileoShoppingRoute>();
		cabinNo=getCabinNo(galileoShoppingRequest.getCabinType().name());
		for (GalileoShoppingRoute route:galileoShoppingResponse.getGalileoShoppingRouteList()) {
			for (GalileoShoppingProcess proces:route.getGalileoShoppingProcessList()) {
				for (GalileoShoppingFlight flight:proces.getGalileoShoppingFlightList()) {
					flightCabinClass=flightCabinClass+getCabinNo(flight.getCabinClass());
				}
				
			}
			if (flightCabinClass>=cabinNo&&flightCabinClass<=10*cabinNo) {
				galileoShoppingRoutes.add(route);
			}
		}
		
		response.setGalileoShoppingRouteList(galileoShoppingRoutes);
		return response;
	}


	private static int getCabinNo(String cabinType) {
		switch (cabinType) {
		case "F":
			return 11;
		case "C":
			return 1;
		case "Y":
			return 0;
		default:
			return 0;
		}
	}
}

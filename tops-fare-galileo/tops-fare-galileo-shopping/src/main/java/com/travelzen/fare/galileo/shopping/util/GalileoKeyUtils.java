package com.travelzen.fare.galileo.shopping.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.lang.StringUtils;

import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.flight.GalileoShoppingFlight;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequestProcess;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingProcess;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.framework.security.MD5;

public class GalileoKeyUtils {
	
private final static String UNDERLINE = "_";
	
	public static String key2Md5(String origin) {
        String rs = MD5.MD5Encode(origin);
        if (StringUtils.isBlank(rs)) {
            return origin;
        }
        return rs;
    }
	
	public static String galileoShoppingRequest2QueryKey(GalileoShoppingRequest req){
		StringBuffer sBuffer=new StringBuffer();
		
		if (req.isSetTripType()) {
            sBuffer.append(req.getTripType().name());
        }
		if(req.isSetPassengerTypeSet() && req.getPassengerTypeSet().size() >0){
			List<GalileoPassengerType> galileoPassengerTypeList = new ArrayList<>(req.getPassengerTypeSet());
			Collections.sort(galileoPassengerTypeList, new Comparator<GalileoPassengerType>(){
				@Override
				public int compare(GalileoPassengerType o1,
						GalileoPassengerType o2) {
					return o1.getValue() - o2.getValue();
				}
			});
			
			for(int i=0;i<galileoPassengerTypeList.size();i++){
				sBuffer.append(UNDERLINE);
				sBuffer.append(galileoPassengerTypeList.get(i).name());
			}
		}
		if(req.isSetCabinType()){
			sBuffer.append(UNDERLINE);
			 sBuffer.append(req.getCabinType());
		}
		if(req.isSetPermittedCarriers() && req.getPermittedCarriers().size()>0){
			sBuffer.append(UNDERLINE);
			 sBuffer.append(req.getPermittedCarriers().get(0));
		}
        
        List<GalileoShoppingRequestProcess> processes=req.getRequestProcessList();
        for(GalileoShoppingRequestProcess process : processes){
        	if(process.isSetFromCity()){
        		sBuffer.append(UNDERLINE);
        		sBuffer.append(process.getFromCity());
        	}
        	
        	if(process.isSetToCity()){
        		sBuffer.append(UNDERLINE);
        		sBuffer.append(process.getToCity());
        	}
        	
        	if(process.isSetFromDate()){
        		sBuffer.append(UNDERLINE);
        		sBuffer.append(process.getFromDate());
        	}
        	
        }
        
		return sBuffer.toString();
	}
	
	public static String galileoShoppingRoute2Key(String passengerType, GalileoShoppingRoute route) {
        List<GalileoShoppingFlight> flights = new ArrayList<GalileoShoppingFlight>();
        
        for (GalileoShoppingProcess process : route.getGalileoShoppingProcessList()) {
            flights.addAll(process.getGalileoShoppingFlightList());
        }
        
        return flightList2key(flights, passengerType, true);
    }
    
    public static String flightList2key(List<GalileoShoppingFlight> flights, String passengerType, boolean isNeedBookingClass) {
    	StringBuffer sb = new StringBuffer();
    	
        if (flights == null || flights.size() == 0 || StringUtils.isBlank(passengerType)) {
            return "";
        }
        
        sb.append(passengerType);
        for (GalileoShoppingFlight flight : flights) {
            sb.append(UNDERLINE);
            sb.append(flight2Key(flight, isNeedBookingClass));
        }
        return sb.toString();
    }

    // AirCompany_FlightNumber_FromAirport_ToAirport_FromDate
    public static String flight2Key(GalileoShoppingFlight flight, boolean isNeedBookingClass) {
        StringBuffer sb = new StringBuffer();
        
        sb.append(flight.getCarrier());
        sb.append(flight.getFlightNumber());
        sb.append(UNDERLINE);
        if (isNeedBookingClass == true) {
        	sb.append(flight.getBookingClass());
            sb.append(UNDERLINE);
        }
        sb.append(flight.getFromAirport());
        sb.append(UNDERLINE);
        sb.append(flight.getToAirport());
        sb.append(UNDERLINE);
        sb.append(flight.getFromDate());
        
        return sb.toString();
    }

}

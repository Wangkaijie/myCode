package com.travelzen.fare.galileo.convertor.request;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import com.travelzen.fare.galileo.convertor.common.CabinTypeConvertor;
import com.travelzen.fare.galileo.convertor.time.GalileoShoppingTimeConvertor;
import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.common.GalileoTripType;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequestProcess;
import com.travelzen.flight.api.galileo.pojo.SearchRequest;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class SearchRequestToGalileoShoppingRequestConvertor {
	private static Logger logger = RequestIdentityLogger.getLogger(SearchRequestToGalileoShoppingRequestConvertor.class);
	
	public static GalileoShoppingRequest searchRequestToGalileoShoppingRequest(SearchRequest searchRequest)throws Exception{
		GalileoShoppingRequest galileoShoppingRequest = null;
		Set<GalileoPassengerType> galileoPassengerTypeSet = null;
		logger.info("in searchRequestToGalileoShoppingRequest, searchRequest.getAdult(): "+searchRequest.getAdult()+"searchRequest.getChild()"+searchRequest.getChild());
		if(null != searchRequest){
			galileoShoppingRequest = new GalileoShoppingRequest();
			galileoPassengerTypeSet = new HashSet<GalileoPassengerType>();
			if(searchRequest.getAdult() >0){
				galileoPassengerTypeSet.add(GalileoPassengerType.ADT);
			}
			if(searchRequest.getChild() >0){
				galileoPassengerTypeSet.add(GalileoPassengerType.CHD);
			}
			galileoShoppingRequest.setPassengerTypeSet(galileoPassengerTypeSet);
			galileoShoppingRequest.setIsDirectFlightOnly(String.valueOf(searchRequest.isIsDirectFlightOnly()));
//			galileoShoppingRequest.setSourceMarkUpAmt(searchRequest.getDSourceMarkUpAmt().toString());
			galileoShoppingRequest.setMaxReturnRouteNum(searchRequest.getMaxRecord());
			
			if(searchRequest.getCabinClass() != null){
				galileoShoppingRequest.setCabinType(CabinTypeConvertor.cabinClassToGalileoCabinType(searchRequest.getCabinClass()));
			}
			
			if(searchRequest.getLPermittedCarriers() != null && searchRequest.getLPermittedCarriers().getString().size()>0){
				galileoShoppingRequest.setPermittedCarriers(searchRequest.getLPermittedCarriers().getString());
			}
			
			if(searchRequest.getLProhibitedCarriers() != null && searchRequest.getLProhibitedCarriers().getString().size()>0){
				galileoShoppingRequest.setProhibitedCarriers(searchRequest.getLProhibitedCarriers().getString());
			}
			
//			if(searchRequest.getSChargeAmt() != null && searchRequest.getSChargeAmt().equals("") == false){
//				galileoShoppingRequest.setChargeAmt(searchRequest.getSChargeAmt());
//			}
//			
//			if(searchRequest.getSChargeBy() != null && searchRequest.getSChargeBy().equals("") == false){
//				galileoShoppingRequest.setChargeBy(searchRequest.getSChargeBy());
//			}
			
			if(searchRequest.getSource() != null && searchRequest.getSource().equals("") == false){
				galileoShoppingRequest.setSource(searchRequest.getSource());
			}
			
//			if(searchRequest.getSOverridePCC() != null && searchRequest.getSOverridePCC().equals("") == false){
//				galileoShoppingRequest.setOverridePCC(searchRequest.getSOverridePCC());
//			}
//			
//			if(searchRequest.getSSourceMarkUpBy() != null && searchRequest.getSSourceMarkUpBy().equals("") == false){
//				galileoShoppingRequest.setSourceMarkUpBy(searchRequest.getSSourceMarkUpBy());
//			}
			
			switch(searchRequest.getTripType()){
			case "1":
				convertOW(galileoShoppingRequest,searchRequest);
				galileoShoppingRequest.setTripType(GalileoTripType.OW);
				break;
			case "2":
				convertRT(galileoShoppingRequest,searchRequest);
				galileoShoppingRequest.setTripType(GalileoTripType.RT);
				break;
				default:
				throw new Exception("in searchRequestToGalileoShoppingRequest, no such tripType: "+searchRequest.getTripType());
			}
		}
		
		return galileoShoppingRequest;
	}
	
	private static GalileoShoppingRequest convertOW(GalileoShoppingRequest galileoShoppingRequest, SearchRequest searchRequest){
		if(null == searchRequest){
			return galileoShoppingRequest;
		}
		if(null == galileoShoppingRequest){
			galileoShoppingRequest = new GalileoShoppingRequest();
		}
		List<GalileoShoppingRequestProcess>  galileoShoppingRequestProcessList = new ArrayList<GalileoShoppingRequestProcess>();
		GalileoShoppingRequestProcess galileoShoppingRequestProcess = null;
		
		if(null != searchRequest.getFromCity() && searchRequest.getFromCity().equals("") == false &&
				null != searchRequest.getToCity() && searchRequest.getToCity().equals("") == false &&
				null != searchRequest.getFromDate() && searchRequest.getFromDate().equals("") == false){
			galileoShoppingRequestProcess = new GalileoShoppingRequestProcess();
			galileoShoppingRequestProcess.setFromCity(searchRequest.getFromCity());
			galileoShoppingRequestProcess.setToCity(searchRequest.getToCity());
			galileoShoppingRequestProcess.setFromDate(
					GalileoShoppingTimeConvertor.convertSearchDateToShoppingDate(searchRequest.getFromDate()));
			galileoShoppingRequestProcessList.add(galileoShoppingRequestProcess);
		}
		
		galileoShoppingRequest.setRequestProcessList(galileoShoppingRequestProcessList);
		return galileoShoppingRequest;
	}
	
	private static GalileoShoppingRequest convertRT(GalileoShoppingRequest galileoShoppingRequest, SearchRequest searchRequest){
		if(null == searchRequest){
			return galileoShoppingRequest;
		}
		if(null == galileoShoppingRequest){
			galileoShoppingRequest = new GalileoShoppingRequest();
		}
		List<GalileoShoppingRequestProcess>  galileoShoppingRequestProcessList = new ArrayList<GalileoShoppingRequestProcess>();
		GalileoShoppingRequestProcess galileoShoppingRequestProcess = null;
		if(null != searchRequest.getFromCity() && searchRequest.getFromCity().equals("") == false &&
				null != searchRequest.getToCity() && searchRequest.getToCity().equals("") == false &&
				null != searchRequest.getFromDate() && searchRequest.getFromDate().equals("") == false &&
				null != searchRequest.getRetDate() && searchRequest.getRetDate().equals("") == false){
			galileoShoppingRequestProcess = new GalileoShoppingRequestProcess();
			galileoShoppingRequestProcess.setFromCity(searchRequest.getFromCity());
			galileoShoppingRequestProcess.setToCity(searchRequest.getToCity());
			galileoShoppingRequestProcess.setFromDate(
					GalileoShoppingTimeConvertor.convertSearchDateToShoppingDate(searchRequest.getFromDate()));
			galileoShoppingRequestProcessList.add(galileoShoppingRequestProcess);
			
			galileoShoppingRequestProcess = new GalileoShoppingRequestProcess();
			galileoShoppingRequestProcess.setFromCity(searchRequest.getToCity());
			galileoShoppingRequestProcess.setToCity(searchRequest.getFromCity());
			galileoShoppingRequestProcess.setFromDate(
					GalileoShoppingTimeConvertor.convertSearchDateToShoppingDate(searchRequest.getRetDate()));
			galileoShoppingRequestProcessList.add(galileoShoppingRequestProcess);
			
		}
		
		galileoShoppingRequest.setRequestProcessList(galileoShoppingRequestProcessList);
		return galileoShoppingRequest;
	}

}

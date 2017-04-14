package com.travelzen.fare.galileo.convertor.request;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.travelzen.fare.galileo.convertor.common.CabinTypeConvertor;
import com.travelzen.fare.galileo.convertor.time.GalileoShoppingTimeConvertor;
import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequestProcess;
import com.travelzen.flight.api.galileo.pojo.ArrayOfString;
import com.travelzen.flight.api.galileo.pojo.SearchRequest;

public class GalileoShoppingRequestToSearchRequestConvertor {
	
	public static SearchRequest galileoShoppingRequestToSearchRequest(GalileoShoppingRequest galileoShoppingRequest)throws Exception{
		SearchRequest searchRequest = null;
		
		if(null != galileoShoppingRequest && galileoShoppingRequest.isSetRequestProcessList() && galileoShoppingRequest.getRequestProcessList().size()>0){
			searchRequest = new SearchRequest();
			
			searchRequest.setSChargeAmt("0");
			searchRequest.setSChargeBy("R");
			searchRequest.setSSourceMarkUpBy("R");
			searchRequest.setDSourceMarkUpAmt(new BigDecimal(0));
			
			if(galileoShoppingRequest.isSetCabinType()){
				searchRequest.setCabinClass(CabinTypeConvertor.galileoCabinTypeToCabinClass(galileoShoppingRequest.getCabinType()));
			}
			
			if(galileoShoppingRequest.isSetIsDirectFlightOnly()){
				searchRequest.setIsDirectFlightOnly(Boolean.parseBoolean(galileoShoppingRequest.getIsDirectFlightOnly()));
			}
			
			if(galileoShoppingRequest.isSetMaxReturnRouteNum()){
				searchRequest.setMaxRecord(galileoShoppingRequest.getMaxReturnRouteNum());
			}
			
			if(galileoShoppingRequest.isSetPassengerTypeSet() && galileoShoppingRequest.getPassengerTypeSet().size() >0){
				Iterator<GalileoPassengerType> iterator = galileoShoppingRequest.getPassengerTypeSet().iterator();
				GalileoPassengerType galileoPassengerType = null;
				while(iterator.hasNext()){
					galileoPassengerType = iterator.next();
					switch(galileoPassengerType){
					case ADT:
						searchRequest.setAdult(1);
						break;
					case CHD:
						searchRequest.setChild(1);
						break;
						default:
							throw new Exception("in galileoShoppingRequestToSearchRequest, no such galileoPassengerType: "+galileoPassengerType);
					}
				}
			}
			
			if(galileoShoppingRequest.isSetPermittedCarriers()){
				ArrayOfString arrayOfString = new ArrayOfString();
				arrayOfString.getString().addAll(galileoShoppingRequest.getPermittedCarriers());
				searchRequest.setLPermittedCarriers(arrayOfString);
			}
			
			if(galileoShoppingRequest.isSetProhibitedCarriers()){
				ArrayOfString arrayOfString = new ArrayOfString();
				arrayOfString.getString().addAll(galileoShoppingRequest.getProhibitedCarriers());
				searchRequest.setLPermittedCarriers(arrayOfString);
			}
			
			if(galileoShoppingRequest.isSetSource()){
				searchRequest.setSource(galileoShoppingRequest.getSource());
			}
			
			if(galileoShoppingRequest.isSetTripType()){
				switch(galileoShoppingRequest.getTripType()){
				case OW:
					convertOW(galileoShoppingRequest.getRequestProcessList().get(0), searchRequest);
					searchRequest.setTripType("1");
					break;
				case RT:
					convertRT(galileoShoppingRequest.getRequestProcessList(), searchRequest);
					searchRequest.setTripType("2");
					break;
					default:
						throw new Exception("in galileoShoppingRequestToSearchRequest, no such GalileoTripType: "+galileoShoppingRequest.getTripType());
				}
			}
		}
		
		return searchRequest;
	}
	
	private static void convertOW(GalileoShoppingRequestProcess galileoShoppingRequestProcess, SearchRequest searchRequest)throws Exception{
		if(null == galileoShoppingRequestProcess){
			throw new Exception("in convertOW, the parameter is null");
		}
		
		if(null == searchRequest){
			searchRequest=new SearchRequest();
		}
		
		if(galileoShoppingRequestProcess.isSetFromCity()){
			searchRequest.setFromCity(galileoShoppingRequestProcess.getFromCity());
		}
		if(galileoShoppingRequestProcess.isSetToCity()){
			searchRequest.setToCity(galileoShoppingRequestProcess.getToCity());
		}
		if(galileoShoppingRequestProcess.isSetFromDate()){
			searchRequest.setFromDate(
					GalileoShoppingTimeConvertor.convertShoppingDateToSearchDate(galileoShoppingRequestProcess.getFromDate()));
		}
		
	}
	
	
	private static void convertRT(List<GalileoShoppingRequestProcess> galileoShoppingRequestProcessList, SearchRequest searchRequest)throws Exception{
		if(null == galileoShoppingRequestProcessList || null == galileoShoppingRequestProcessList.get(0) || null == galileoShoppingRequestProcessList.get(1)){
			throw new Exception("in convertRT, the parameter is null");
		}
		if(galileoShoppingRequestProcessList.size() !=2 ){
			throw new Exception("in convertRT, number of processes !=2");
		}
		
		if(null == searchRequest){
			searchRequest=new SearchRequest();
		}
		
		if(galileoShoppingRequestProcessList.get(0).isSetFromCity()){
			searchRequest.setFromCity(galileoShoppingRequestProcessList.get(0).getFromCity());
		}
		if(galileoShoppingRequestProcessList.get(0).isSetToCity()){
			searchRequest.setToCity(galileoShoppingRequestProcessList.get(0).getToCity());
		}
		if(galileoShoppingRequestProcessList.get(0).isSetFromDate()){
			searchRequest.setFromDate(
					GalileoShoppingTimeConvertor.convertShoppingDateToSearchDate(
							galileoShoppingRequestProcessList.get(0).getFromDate()));
		}
		if(galileoShoppingRequestProcessList.get(1).isSetFromDate()){
			searchRequest.setRetDate(
					GalileoShoppingTimeConvertor.convertShoppingDateToSearchDate(
							galileoShoppingRequestProcessList.get(1).getFromDate()));
		}
		
	}

}

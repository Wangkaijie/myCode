package com.travelzen.fare.galileo.shopping.datacenterstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.google.gson.Gson;
import com.travelzen.fare.basic.data.cabinshopping.requestresponse.CabinShoppingRequest;
import com.travelzen.fare.basic.data.shopping.client.util.BasicDataShoppingClientUtil;
import com.travelzen.fare.galileo.convertor.common.FareTypeConvertor;
import com.travelzen.fare.galileo.convertor.common.TaxTypeConvertor;
import com.travelzen.fare.galileo.convertor.common.TripTypeConvertor;
import com.travelzen.fare.galileo.convertor.route.RouteingToGalileoRouteConvertor;
import com.travelzen.fare.galileo.convertor.time.GalileoShoppingTimeConvertor;
import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable;
import com.travelzen.fare.galileo.shopping.flight.GalileoShoppingFlight;
import com.travelzen.fare.galileo.shopping.flight.GalileoShoppingFlightStopOver;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingProcess;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.fare.galileo.shopping.util.GalileoKeyUtils;
import com.travelzen.fare.galileo.shopping.util.GalileoShoppingBaseDataUtil;
import com.travelzen.fare.galileo.shopping.util.GalileoShoppingTimeUtil;
import com.travelzen.flight.api.galileo.bean.GalileoVerifyRequest;
import com.travelzen.flight.api.galileo.pojo.ItineraryPricing;
import com.travelzen.flight.api.galileo.pojo.ItineraryPricingRequest;
import com.travelzen.flight.api.galileo.pojo.Routeing;
import com.travelzen.flight.api.galileo.pojo.SearchResult;
import com.travelzen.flight.api.galileo.pojo.Segment;
import com.travelzen.flight.api.utils.GalileoXmlDataFilter;
import com.travelzen.flight.api.utils.XmlConvert;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class GalileoShoppingParser {
	
private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingParser.class);
	
	public static GalileoShoppingResponse searchResultToGalileoShoppingResponse(SearchResult searchResult, GalileoShoppingResponse galileoShoppingResponse)throws Exception{
		GalileoShoppingErrorTable error=new GalileoShoppingErrorTable();
		
		if(null == searchResult || (searchResult.getStatus() ==0 && searchResult.getRouteing().getRouteing().size()<=0)){
			error.setErrorCode("204");
			error.setErrorMsg("GDS返回结果为空");
			galileoShoppingResponse.setError(	error);
			return galileoShoppingResponse;
		}
		
		if(null != searchResult && searchResult.getStatus() !=0){
			error.setErrorCode("204");
			error.setErrorMsg("GDS查询失败");
			galileoShoppingResponse.setError(	error);
			
			return galileoShoppingResponse;
		}
		
		try{
			if(searchResult.getId() != null && searchResult.getId().equals("") ==false){
				galileoShoppingResponse.setId(searchResult.getId());
			}
			galileoShoppingResponse=addGalileoRoutingToGalileoShoppingResponse(searchResult.getRouteing().getRouteing(),galileoShoppingResponse);
		}catch(Exception e){
			throw e;
		}
		
		//logger.info("返回的galileoShoppingResponse : "+galileoShoppingResponse);
		return galileoShoppingResponse;
	}
	
	private static GalileoShoppingResponse addGalileoRoutingToGalileoShoppingResponse(List<Routeing> routeingList, GalileoShoppingResponse galileoShoppingResponse)throws Exception{
		List<GalileoShoppingRoute> galileoShoppingRouteList = new ArrayList<GalileoShoppingRoute>();
		GalileoShoppingRoute galileoShoppingRoute = null;
		ItineraryPricingRequest itineraryPricingRequest = null;
		 XmlConvert xmlConvert = new XmlConvert(new GalileoXmlDataFilter());
		 ItineraryPricing itineraryPricing = null;
		 GalileoVerifyRequest galileoVerifyRequest = null;
		int count = 0;
		for(Routeing routeing : routeingList){
			if(null == routeing || (routeing.getAdultPrice().compareTo(BigDecimal.ZERO) <=0 && routeing.getChildPrice().compareTo(BigDecimal.ZERO) <=0)){
				continue;
			}
			
			String tripTypeString = galileoShoppingResponse.getQueryKey().substring(0, 2);
			tripTypeString = TripTypeConvertor.galileoShoppingTripTypeToTripType(tripTypeString);
			
			if(routeing.getAdultPrice().compareTo(BigDecimal.ZERO) >0){
				galileoShoppingRoute = convertGalileoRoutingToGalileoShoppingRoute(routeing,GalileoPassengerType.ADT,count);
				count++;
				galileoVerifyRequest = new GalileoVerifyRequest();
				itineraryPricingRequest = new ItineraryPricingRequest();
				itineraryPricingRequest.setRouting(routeing);
				itineraryPricingRequest.setTripType(tripTypeString);
				galileoVerifyRequest.setRoute(RouteingToGalileoRouteConvertor.routeingToGalileoRoute(routeing));
				galileoVerifyRequest.setTripType(TripTypeConvertor.tripTypeToGalileoTripType(tripTypeString));
				itineraryPricing = new ItineraryPricing();
		        itineraryPricing.setOItineraryPricing(itineraryPricingRequest);
				galileoShoppingRoute.setGalileoShoppingCabinVerify(new Gson().toJson(galileoVerifyRequest));
				galileoShoppingRoute.setGalileoShoppingPriceVerify(new Gson().toJson(galileoVerifyRequest));
				galileoShoppingRoute.setGalileoShoppingFareRuleRequest(xmlConvert.encode(itineraryPricing));
				galileoShoppingRoute.setRouteKey(GalileoKeyUtils.galileoShoppingRoute2Key(GalileoPassengerType.ADT.name(), galileoShoppingRoute));
				galileoShoppingRouteList.add(galileoShoppingRoute);
			}
			if(routeing.getChildPrice().compareTo(BigDecimal.ZERO) >0){
				galileoShoppingRoute = convertGalileoRoutingToGalileoShoppingRoute(routeing,GalileoPassengerType.CHD,count);
				count++;
				galileoVerifyRequest = new GalileoVerifyRequest();
				itineraryPricingRequest = new ItineraryPricingRequest();
				itineraryPricingRequest.setRouting(routeing);
				itineraryPricingRequest.setTripType(tripTypeString);
				galileoVerifyRequest.setRoute(RouteingToGalileoRouteConvertor.routeingToGalileoRoute(routeing));
				galileoVerifyRequest.setTripType(TripTypeConvertor.tripTypeToGalileoTripType(tripTypeString));
				itineraryPricing = new ItineraryPricing();
		        itineraryPricing.setOItineraryPricing(itineraryPricingRequest);
				galileoShoppingRoute.setGalileoShoppingCabinVerify(new Gson().toJson(galileoVerifyRequest));
				galileoShoppingRoute.setGalileoShoppingPriceVerify(new Gson().toJson(galileoVerifyRequest));
				galileoShoppingRoute.setGalileoShoppingFareRuleRequest(xmlConvert.encode(itineraryPricing));
				galileoShoppingRoute.setRouteKey(GalileoKeyUtils.galileoShoppingRoute2Key(GalileoPassengerType.CHD.name(), galileoShoppingRoute));
				galileoShoppingRouteList.add(galileoShoppingRoute);
			}
		}
		
		//批量请求航班舱等
		GalileoShoppingBaseDataUtil.getgetCabinClass(galileoShoppingRouteList);
		galileoShoppingResponse.setGalileoShoppingRouteList(galileoShoppingRouteList);
		return galileoShoppingResponse;
		
	}
	
	private static GalileoShoppingRoute convertGalileoRoutingToGalileoShoppingRoute(Routeing routeing, GalileoPassengerType passengerType,int count)throws Exception{
		if(null == routeing || passengerType.equals("")){
			return null;
		}
		
		GalileoShoppingProcess galileoShoppingProcess = null;
		GalileoShoppingRoute galileoShoppingRoute  =new GalileoShoppingRoute();
		List<GalileoShoppingProcess> galileoShoppingProcessList = new ArrayList<GalileoShoppingProcess>();
		int flightCount = 0;
		
		
		if(passengerType == GalileoPassengerType.ADT){
			galileoShoppingRoute.setPassengerType(GalileoPassengerType.ADT);
			galileoShoppingRoute.setHkdPrice(routeing.getAdultPrice().intValue());
			galileoShoppingRoute.setOrgPrice(routeing.getAdultOrgPrice().intValue());
			galileoShoppingRoute.setHkdTax(routeing.getAdultTax().intValue());
			galileoShoppingRoute.setOrgTax(routeing.getAdultOrgTax().intValue());
			galileoShoppingRoute.setTaxType(TaxTypeConvertor.taxTypeToGalileoShoppingTaxType(routeing.getAdultTaxType()));
		}
		
		if(passengerType == GalileoPassengerType.CHD){
			galileoShoppingRoute.setPassengerType(GalileoPassengerType.CHD);
			galileoShoppingRoute.setHkdPrice(routeing.getChildPrice().intValue());
			galileoShoppingRoute.setOrgPrice(routeing.getChildOrgPrice().intValue());
			galileoShoppingRoute.setHkdTax(routeing.getChildTax().intValue());
			galileoShoppingRoute.setOrgTax(routeing.getChildOrgTax().intValue());
			galileoShoppingRoute.setTaxType(TaxTypeConvertor.taxTypeToGalileoShoppingTaxType(routeing.getChildTaxType()));
		}
		
		if(null != routeing.getFromSegments() && routeing.getFromSegments().getSegment().size()>0){
			try{
				galileoShoppingProcess = convertGalileoSearchSegmentsToGalileoShoppingProcess(routeing.getFromSegments().getSegment());
				flightCount += galileoShoppingProcess.getGalileoShoppingFlightList().size();
				galileoShoppingProcessList.add(galileoShoppingProcess);
			}catch(Exception e){
				throw e;
			}
		}
		
		if(null != routeing.getRetSegments() && routeing.getRetSegments().getSegment().size()>0){
			try{
				galileoShoppingProcess = convertGalileoSearchSegmentsToGalileoShoppingProcess(routeing.getRetSegments().getSegment());
				flightCount += galileoShoppingProcess.getGalileoShoppingFlightList().size();
				galileoShoppingProcessList.add(galileoShoppingProcess);
			}catch(Exception e){
				throw e;
			}
		}
		
		if(null != routeing.getFareType()){
			galileoShoppingRoute.setFareType(FareTypeConvertor.searchFareTypeToGalileoShoppingFareType(routeing.getFareType()));
		}
		if(null != routeing.getFareBasis() && routeing.getFareBasis().equals("") == false){
			galileoShoppingRoute.setFareBasis(routeing.getFareBasis());
		}
		galileoShoppingRoute.setApplyType(routeing.getApplyType());
		galileoShoppingRoute.setPriceType(routeing.getPriceType());
		galileoShoppingRoute.setGalileoShoppingProcessList(galileoShoppingProcessList);
		galileoShoppingRoute.setFilingAirCompany(galileoShoppingProcessList.get(0).getGalileoShoppingFlightList().get(0).getCarrier());
		galileoShoppingRoute.setFlightCount(flightCount);
		galileoShoppingRoute.setId(count);
		
		
		return galileoShoppingRoute;
		
	}
	
	private static GalileoShoppingProcess convertGalileoSearchSegmentsToGalileoShoppingProcess(List<Segment> segmentList)throws Exception{
		
		if(null == segmentList || segmentList.size() <= 0){
			throw new Exception("in convertGalileoSearchSegmentsToGalileoShoppingProcess, segmentList is null");
		}
		
		GalileoShoppingProcess process = null;
		List<GalileoShoppingFlight> flights = convertGalileoSearchSegmentsToGalileoShoppingFlights(segmentList);
		
		if(null != flights && flights.size()>0){
			process = new GalileoShoppingProcess();
			
			process.setFromCity(flights.get(0).getFromCity());
			process.setFromAirport(flights.get(0).getFromAirport());
			process.setFromDate(flights.get(0).getFromDate());
			process.setFromTime(flights.get(0).getFromTime());
			
			process.setToCity(flights.get(flights.size()-1).getToCity());
			process.setToAirport(flights.get(flights.size() -1).getToAirport());
			process.setToDate(flights.get(flights.size() -1).getToDate());
			process.setToTime(flights.get(flights.size() -1).getToTime());
			
			process.setGalileoShoppingFlightList(flights);
		}

		return process;
		
	}
	
private static List<GalileoShoppingFlight> convertGalileoSearchSegmentsToGalileoShoppingFlights(List<Segment> segmentList)throws Exception{
		
		if(null == segmentList || segmentList.size() <= 0){
			throw new Exception("in convertGalileoSearchSegmentsToGalileoShoppingFlights, segmentList is null");
		}
		
		List<GalileoShoppingFlight> flights = new ArrayList<GalileoShoppingFlight>();
		GalileoShoppingFlight flight = null;
		
		for(Segment segment : segmentList){
			flight = new GalileoShoppingFlight();
			
			if(segment.getCarrier() != null && segment.getCarrier().equals("") == false){
				flight.setCarrier(segment.getCarrier());
			}
			
			if(segment.getFlightNumber() != null && segment.getFlightNumber().equals("") == false){
				flight.setFlightNumber(segment.getFlightNumber().substring(segment.getCarrier().length()));
			}
			
			if(segment.getDepAirport() != null && segment.getDepAirport().equals("") == false){
				flight.setFromAirport(segment.getDepAirport());
			}
			
			if(segment.getDepTime() != null && segment.getDepTime().equals("") == false){
				flight.setFromDate(
						GalileoShoppingTimeConvertor.convertSearchDateTimeToShoppingDate(segment.getDepTime()));
				flight.setFromTime(
						GalileoShoppingTimeConvertor.convertSearchDateTimeToShoppingTime(segment.getDepTime()));
			}
			
			if(segment.getArrAirport() != null && segment.getArrAirport().equals("") == false){
				flight.setToAirport(segment.getArrAirport());
			}
			
			if(segment.getArrTime() != null && segment.getArrTime().equals("") == false){
				flight.setToDate(
						GalileoShoppingTimeConvertor.convertSearchDateTimeToShoppingDate(segment.getArrTime()));
				flight.setToTime(
						GalileoShoppingTimeConvertor.convertSearchDateTimeToShoppingTime(segment.getArrTime()));
			}
			
			if(segment.getStopCities() != null && segment.getStopCities().equals("") == false){
				flight.setGalileoShoppingFlightStopOverList(
						convertGalileoSearchStopOverToGalileoShoppingStopOver(segment.getStopCities()));
			}
			
			if(segment.getCabin() != null && segment.getCabin().equals("") == false){
				flight.setBookingClass(segment.getCabin());
			}
			
			if(segment.getAircraftCode() != null && segment.getAircraftCode().equals("") == false){
				flight.setEquipType(segment.getAircraftCode());
			}
			
			if(segment.getMarketAirlines() != null && segment.getMarketAirlines().equals("") == false){
				flight.setMarketAirlines(segment.getMarketAirlines());
			}
			
			if(segment.getBookingcodeinfo() != null && segment.getBookingcodeinfo().equals("") == false){
				flight.setSeatLeft(segment.getBookingcodeinfo());
			}

			flight.setCodeShare(String.valueOf(segment.isCodeShare()));
			flight.setDuration(GalileoShoppingTimeUtil.computeDuration(segment.getAirTime()));
			flight.setFarePrice(segment.getFarePrice().intValue());
				
			flight.setFlightKey(GalileoKeyUtils.flight2Key(flight, false));
			flight.setFromCity(GalileoShoppingBaseDataUtil.getCityOfAirport(flight.getFromAirport()));
			flight.setToCity(GalileoShoppingBaseDataUtil.getCityOfAirport(flight.getToAirport()));
			flights.add(flight);
			//构造getCabinClass参数,最后批量获取
			//flight.setCabinClass(GalileoShoppingBaseDataUtil.getCabinClassOfCabin(flight.getCarrier(), flight.getBookingClass(),flight.getFromDate(),""));
		
		}
		
		return flights;
		
	}


private static List<GalileoShoppingFlightStopOver> convertGalileoSearchStopOverToGalileoShoppingStopOver(String stopOver){
	
	if(stopOver.equals("")){
		return null;
	}
	
	List<GalileoShoppingFlightStopOver> flightStopOvers = new ArrayList<GalileoShoppingFlightStopOver>();
	GalileoShoppingFlightStopOver flightStopOver = null;
	
	String[] stopOvers = stopOver.split("/");
	
	for(String s : stopOvers){
		flightStopOver = new GalileoShoppingFlightStopOver();
		flightStopOver.setStopAirport(s);
		flightStopOvers.add(flightStopOver);
		
	}
	
	return flightStopOvers;
	
}

}

package com.travelzen.fare.galileo.convertor.common;

import com.travelzen.fare.galileo.shopping.common.GalileoShoppingFareType;
import com.travelzen.flight.api.galileo.bean.GalileoFareType;
import com.travelzen.flight.api.galileo.pojo.FareType;

public class FareTypeConvertor {
	
	public static GalileoShoppingFareType searchFareTypeToGalileoShoppingFareType(FareType fareType)throws Exception{
		switch(fareType){
		case PUBLISHED_FARE:
			return GalileoShoppingFareType.PUBLISHEDFARE;
		case CONSOLE_FARE:
			return GalileoShoppingFareType.CONSOLEFARE;
			default:
				throw new Exception("in searchFareTypeToGalileoShoppingFareType, no such fareType: "+fareType);
		
		}
	}
	
	public static GalileoFareType searchFareTypeToGalileoFareType(FareType fareType)throws Exception{
		switch(fareType){
		case PUBLISHED_FARE:
			return GalileoFareType.PUBLISHED;
		case CONSOLE_FARE:
			return GalileoFareType.CONSOLE;
			default:
				return GalileoFareType.UNKNOWN;
		}
	}

}

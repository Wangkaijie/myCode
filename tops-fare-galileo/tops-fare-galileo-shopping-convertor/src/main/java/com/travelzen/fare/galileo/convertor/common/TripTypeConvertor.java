package com.travelzen.fare.galileo.convertor.common;


import com.travelzen.flight.api.galileo.bean.GalileoTripType;

public class TripTypeConvertor {
	
	public static GalileoTripType tripTypeToGalileoTripType(String tripType){
		switch(tripType){
		case "1":
			return GalileoTripType.OW;
		case "2":
			return GalileoTripType.RT;
		case "3":
			return GalileoTripType.GAP;
			default:
				return GalileoTripType.UNKNOWN;
		}
}
	
	public static String galileoShoppingTripTypeToTripType(String galileoShoppingTripType)throws Exception{
		
		switch(galileoShoppingTripType){
		case "OW":
			return "1";
		case "RT":
			return "2";
			default:
				throw new Exception("in galileoShoppingTripTypeToTripType, no such tripType: "+galileoShoppingTripType);
		}
	}
	
	
	
	
}

package com.travelzen.fare.galileo.convertor.common;

import org.springframework.aop.ThrowsAdvice;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;
import com.travelzen.fare.galileo.shopping.common.GalileoCabinType;
import com.travelzen.flight.api.galileo.pojo.CabinClass;

public class CabinTypeConvertor {
	
	public static CabinClass galileoCabinTypeToCabinClass(GalileoCabinType galileoCabinType)throws Exception{
		
		switch(galileoCabinType){
		case Y:
			return CabinClass.ECONOMY;
		case C:
			return CabinClass.BUSINESS;
		case F:
			return CabinClass.FIRST;
		case PF:
			return CabinClass.PREMIUM_FIRST;
		case PY:
			return CabinClass.PREMIUM_ECONOMY;
			default:
				throw new Exception("in galileoCabinTypeToCabinClass, no such GalileoCabinType,it is :"+galileoCabinType);
		}
	}
	
	public static GalileoCabinType cabinClassToGalileoCabinType(CabinClass cabinClass)throws Exception{
		
		switch(cabinClass){
		case ECONOMY:
			return GalileoCabinType.Y;
		case FIRST:
			return GalileoCabinType.F;
		case BUSINESS:
			return GalileoCabinType.C;
		case PREMIUM_ECONOMY:
			return GalileoCabinType.PY;
		case PREMIUM_FIRST:
			return GalileoCabinType.PF;
			default:
				throw new Exception("in cabinClassToGalileoCabinType, no such cabinClass: "+cabinClass);
		}
		
		
	}

}

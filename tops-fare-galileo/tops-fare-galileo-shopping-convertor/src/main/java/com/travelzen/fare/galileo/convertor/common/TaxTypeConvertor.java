package com.travelzen.fare.galileo.convertor.common;

import com.travelzen.fare.galileo.shopping.common.GalileoShoppingTaxType;

public class TaxTypeConvertor {
	
	public static GalileoShoppingTaxType taxTypeToGalileoShoppingTaxType(int taxType)throws Exception{
		switch(taxType){
		case 0:
			return GalileoShoppingTaxType.EXCLUDINGTAX;
		case 1:
			return GalileoShoppingTaxType.INCLUDINGTAX;
			default:
				throw new Exception("in taxTypeToGalileoShoppingTaxType, no such taxType:"+taxType);
		}
	}

}

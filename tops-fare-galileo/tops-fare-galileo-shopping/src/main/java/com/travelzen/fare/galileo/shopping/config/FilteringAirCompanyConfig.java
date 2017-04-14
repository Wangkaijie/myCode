package com.travelzen.fare.galileo.shopping.config;

import com.travelzen.framework.config.tops.TopsConfReader;
import com.travelzen.framework.config.tops.TopsConfEnum.ConfScope;


public class FilteringAirCompanyConfig {
	
	private static final String CACHE_DIR = "filteringaircompany.properties";
	private static final String AIRCOMPANY = "airCompany";
	
	public static String getAirCompany(){
		return TopsConfReader.getConfContent(CACHE_DIR, AIRCOMPANY, ConfScope.G);
	}
	
	

}

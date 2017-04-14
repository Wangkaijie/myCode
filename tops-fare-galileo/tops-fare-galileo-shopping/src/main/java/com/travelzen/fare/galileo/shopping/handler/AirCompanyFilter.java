package com.travelzen.fare.galileo.shopping.handler;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.travelzen.fare.galileo.shopping.config.FilteringAirCompanyConfig;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class AirCompanyFilter {
	
	private static Logger logger = RequestIdentityLogger.getLogger(AirCompanyFilter.class);
	
	private static Set<String> airCompany = new HashSet<String>();
	private static AirCompanyFilter airCompanyFilter = new AirCompanyFilter();
	
	private AirCompanyFilter(){
		String[] airCompanyArray = null;
		
		String airCompanies = FilteringAirCompanyConfig.getAirCompany();
		
		if(StringUtils.isBlank(airCompanies) == false){
			airCompanyArray = airCompanies.split(",");
		}
		
		for(String s : airCompanyArray){
			airCompany.add(s);
		}
	}
	
	public static boolean isContainAirCompany(String airCompanyString){
		
		return airCompany.contains(airCompanyString) == true;
	}

}

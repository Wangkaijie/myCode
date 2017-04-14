package com.travelzen.fare.galileo.shopping.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.travelzen.fare.galileo.shopping.client.util.GalileoShoppingClientUtil;
import com.travelzen.fare.galileo.shopping.common.GalileoCabinType;
import com.travelzen.fare.galileo.shopping.common.GalileoPassengerType;
import com.travelzen.fare.galileo.shopping.common.GalileoTripType;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequest;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingRequestProcess;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;

public class TestGalileoSearch {
	
	public static void main(String[] args) {
		
		GalileoShoppingRequest request = new GalileoShoppingRequest();
		GalileoShoppingRequestProcess process = new GalileoShoppingRequestProcess();
		Set<GalileoPassengerType> galileoPassengerTypeSet = null;
		process.setFromCity("HKG");
		process.setToCity("SHA");
		process.setFromDate("2016-03-24");
		
		List<GalileoShoppingRequestProcess> requestProcessList = new ArrayList<GalileoShoppingRequestProcess>();
		requestProcessList.add(process);
		request.setRequestProcessList(requestProcessList);
		List<String> carrier = new ArrayList<String>();
//		carrier.add("FM");
		
		galileoPassengerTypeSet = new HashSet<GalileoPassengerType>();
		galileoPassengerTypeSet.add(GalileoPassengerType.ADT);
		request.setCabinType(GalileoCabinType.Y);
		request.setMaxReturnRouteNum(10);
//		request.setPermittedCarriers(carrier);
//		request.setChargeAmt("");
//		request.setChargeBy("");
//		request.setSource("Uapi");
//		request.setOverridePCC("");
//		request.setSourceMarkUpBy("");
//		request.setSourceMarkUpAmt("");
		request.setTripType(GalileoTripType.OW);
		
		try{
			System.out.println("request: "+request);
			GalileoShoppingResponse response =GalileoShoppingClientUtil.getClientInstance().galileoFareSearch(request);
			System.out.println("GalileoShoppingResponse : "+ response);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

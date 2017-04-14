package com.travelzen.fare.galileo.convertor.time;

public class GalileoShoppingTimeConvertor {
	
	public static String convertSearchDateToShoppingDate(String searchDate){
		StringBuilder sBuilder=new StringBuilder(searchDate);
		sBuilder.insert(4, '-');
		sBuilder.insert(7, '-');
		
		return sBuilder.toString();
	}
	
	public static String convertShoppingDateToSearchDate(String shoppingDate){
		return shoppingDate.replaceAll("-", "");
	}
	
	public static String convertSearchDateTimeToShoppingDate(String searchDateTime){
		String sDate=searchDateTime.substring(0, 8);
		StringBuilder sBuilder=new StringBuilder(sDate);
		sBuilder.insert(4, '-');
		sBuilder.insert(7, '-');
		
		return sBuilder.toString();
	}
	
	public static String convertSearchDateTimeToShoppingTime(String searchDateTime){
		String sTime=searchDateTime.substring(8);
		StringBuilder sBuilder=new StringBuilder(sTime);
		sBuilder.insert(2, ':');
		
		return sBuilder.toString();
	}
	
	
	public static String convertShoppingDateTimeToSearchDateTime(String shoppingDateTime){
		shoppingDateTime=shoppingDateTime.replaceAll("-", "");
		shoppingDateTime=shoppingDateTime.replaceAll(" ", "");
		shoppingDateTime=shoppingDateTime.replaceAll(":", "");
		
		return shoppingDateTime;
	}
	
	
	
	public static void main(String[] args){
		String s ="2015-02-03 12:30";
		s=s.replaceAll("-", "");
		s=s.replaceAll(" ", "");
		s=s.replaceAll(":", "");
		
		System.out.println(s);
	}

}

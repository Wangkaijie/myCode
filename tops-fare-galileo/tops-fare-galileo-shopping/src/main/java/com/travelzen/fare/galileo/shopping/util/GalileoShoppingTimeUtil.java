package com.travelzen.fare.galileo.shopping.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponseStatusEnum;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.framework.util.DateUtils;

public class GalileoShoppingTimeUtil {
	
private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingTimeUtil.class);
	
    private final static int GalileoInvalidTIme = 6 * 60 * 60 * 1000;
    private final static int GalileoTriggerTime = 10 * 60 * 1000;                           // 搜索时间 10 分钟有效
  
    private final static int minute=1000*60;
    private final static int hour=60*minute;
    private final static int day=24*hour;
	public static String computeDuration(String minuteString)throws Exception{
		
		if(StringUtils.isBlank(minuteString)){
			throw new Exception("in GalileoShoppingTimeUtil:computeDuration, parameter is 空");
		}
		
		String durationRs="";
		int m = Integer.parseInt(minuteString);
		try{
						
			long hour=m/60;
			long minute =m%60;
			
			durationRs=durationRs+String.format("%02d", hour)+":"+String.format("%02d", minute);
			
			return durationRs;
		}catch(Exception e){
			throw e;
		}
		
	}
	
	
	
    public static boolean isTriggerWithFlight(long lastUpdateDateTime) {
    	long currentTime = System.currentTimeMillis();
    	
    	if (currentTime - lastUpdateDateTime > GalileoTriggerTime) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean isInvalidWithFlight(long lastUpdateDateTime) {
    	long currentTime = System.currentTimeMillis();
    	
    	if (currentTime - lastUpdateDateTime > GalileoInvalidTIme) {
    		return true;
    	}
    	
    	return false;
    }
    
    
    
    public static  GalileoShoppingResponseStatusEnum getStatuEnum (long lastUpdateTime,long departureDateTime){
    	GalileoShoppingResponseStatusEnum responseStatusEnum=null;
    	long currentTime=System.currentTimeMillis();
    	long departureDateTimeInterval=departureDateTime-currentTime;
    	long cachDuration=currentTime-lastUpdateTime;
    	
    	if(departureDateTimeInterval<0){
    		return null;
    	}
    	
    	if(departureDateTimeInterval>0&&departureDateTimeInterval<=10*day){
    		if(cachDuration>0&&cachDuration<hour){
    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Fresh;
    		}else if (cachDuration>hour&&cachDuration<2*hour) {
    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Valid;
			}else if (cachDuration>2*hour&&cachDuration<3*hour) {
				responseStatusEnum=GalileoShoppingResponseStatusEnum.InValid;
			}else {
				return null;
			}
    		
    	}else if (departureDateTimeInterval>10*day&&departureDateTimeInterval<=20*day){
    		if(cachDuration>0&&cachDuration<2*hour){
    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Fresh;
    		}else if (cachDuration>2*hour&&cachDuration<3*hour) {
    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Valid;
			}else if (cachDuration>3*hour&&cachDuration<4*hour) {
				responseStatusEnum=GalileoShoppingResponseStatusEnum.InValid;
			}else {
				return null;
			}
			
		}else if (departureDateTimeInterval>0&&departureDateTimeInterval<=30*day){
    		if(cachDuration>0&&cachDuration<3*hour){
    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Fresh;
    		}else if (cachDuration>3*hour&&cachDuration<4*hour) {
    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Valid;
			}else if (cachDuration>4*hour&&cachDuration<5*hour) {
				responseStatusEnum=GalileoShoppingResponseStatusEnum.InValid;
			}else {
				return null;
			}
			
		}else {
			
	    		if(cachDuration>0&&cachDuration<4*hour){
	    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Fresh;
	    		}else if (cachDuration>4*hour&&cachDuration<6*hour) {
	    			responseStatusEnum=GalileoShoppingResponseStatusEnum.Valid;
				}else if (cachDuration>6*hour&&cachDuration<10*hour) {
					responseStatusEnum=GalileoShoppingResponseStatusEnum.InValid;
				}else {
					return null;
				}
		}
    	
    	
    	return responseStatusEnum;
    }
    
    
    // 获取当天 00:00 分的毫秒数
    public static long currentDateTime() {
        Date date = new Date();
        
        String formatDate = DateUtils.formatDate(date, "yyyy-MM-dd");
        formatDate = formatDate + " 00:00:00";
        date = DateUtils.getDate(formatDate, null);
        
        return date.getTime();
    }
    
    
    public static Date nextDateTime(){
    	Calendar calendar=Calendar.getInstance();
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	Date date=calendar.getTime();
    	if(date.before(new Date())){
    		calendar.add(Calendar.DAY_OF_MONTH, 1);
    		date=calendar.getTime();
    	}
    	
    	String formatDate=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(date);
        date = DateUtils.getDate(formatDate, null);
    	
    	return date;
    }
	
	
	
	public static void main(String[] args){
//		SimpleDateFormat f = new SimpleDateFormat("dd HH:mm");
//		long oneDayMills = FareDateTimeUtil.getMillisSecondsWithOneDay();
//		oneDayMills++;
//		
//		Date d = new Date(oneDayMills);
//		
//		System.out.println(f.format(d));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String durationRs="";
		
		try{
			Date from = sdf.parse("201512220815");
			Date to = sdf.parse("201512221320");
			long dur = to.getTime() - from.getTime();
			long day=dur/(24*60*60*1000);
			long hour=(dur%(24*60*60*1000))/(60*60*1000);
			long minute =((dur%(24*60*60*1000))%(60*60*1000))/(60*1000);
			
			if(day>0){
				durationRs=durationRs+String.format("%02d", day)+" ";
			}
			if(hour>0){
				durationRs=durationRs+String.format("%02d", hour)+":"+String.format("%02d", minute);
			}

		}catch(Exception e){
			System.out.println(durationRs);
		}
		
	}

}

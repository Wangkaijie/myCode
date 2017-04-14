package com.travelzen.fare.galileo.shopping.farerule.search;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GalileoShoppingFareRuleSearchThreadController {
	private final static int GALILEO_FARE_RULE_MAX_NUM = 5;
	private static ThreadPoolExecutor threadPoolExecutor;
	
	static{
		BlockingQueue<Runnable> queue=new  ArrayBlockingQueue<Runnable>(GALILEO_FARE_RULE_MAX_NUM);
		threadPoolExecutor=new ThreadPoolExecutor(GALILEO_FARE_RULE_MAX_NUM,GALILEO_FARE_RULE_MAX_NUM,
				20l,TimeUnit.SECONDS,queue,new ThreadPoolExecutor.DiscardPolicy());				
		}
	
	public static ThreadPoolExecutor getExecutor(){
		return threadPoolExecutor;
	}

}

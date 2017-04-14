package com.travelzen.fare.galileo.shopping.config;

import org.slf4j.Logger;

import com.travelzen.framework.config.tops.TopsConfReader;
import com.travelzen.framework.config.tops.TopsConfEnum.ConfScope;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class DataCenterStorageTrigger {
private static Logger logger = RequestIdentityLogger.getLogger(DataCenterStorageTrigger.class);
	
    private static final String CACHE_DIR = "galileoshopping.properties";

    private static final String SHOPPINGTRIGGER = "shoppingtrigger";

    public static long getShoppingTriggerConf() {
    	long watiMills = TopsConfReader.getConfContentForLong(CACHE_DIR, SHOPPINGTRIGGER, ConfScope.G);
    	logger.info("一次查询等待时间：" + watiMills);
        return watiMills;
    }

}

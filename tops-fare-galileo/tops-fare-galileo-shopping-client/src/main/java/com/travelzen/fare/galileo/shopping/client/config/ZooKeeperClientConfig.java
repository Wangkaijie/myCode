package com.travelzen.fare.galileo.shopping.client.config;

import org.slf4j.Logger;

import com.travelzen.framework.config.tops.TopsConfReader;
import com.travelzen.framework.config.tops.TopsConfEnum.ConfScope;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class ZooKeeperClientConfig {
	
	private static Logger logger = RequestIdentityLogger.getLogger(ZooKeeperClientConfig.class);

    private static final String ZOOKEEPER_SERVER_DIR = "tops-fare-galileo-shopping-client/tops-fare-galileo-shopping-client.properties";

    private static final String IP = "service.ip";
    private static final String PORT = "service.port";
    private static final String ZKPATH = "zookeeper.prefix";
    private static final String ZKNAME = "zookeeper.name";
    private static final String TIMEOUT = "service.timeout";

    public static String getIp() {
        String ipString = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, IP, ConfScope.R);
        logger.info("service.ip:" + ipString);

        return ipString;
    }

    public static String getPort() {
        String portString = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, PORT, ConfScope.R);
        logger.info("service.port:" + portString);

        return portString;
    }

    public static String getZKPath() {
        String servicePath = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, ZKPATH, ConfScope.R);
        logger.info("zookeeper.prefix:" + servicePath);
        
        return servicePath;
    }
    
    public static String getZKName() {
    	String servicePath = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, ZKNAME, ConfScope.R);
        logger.info("zookeeper.name:" + servicePath);
        
        return servicePath;
    }

    public static String getTimeOut() {
        String timeOutString = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, TIMEOUT, ConfScope.R);
        logger.info("service.timeout:" + timeOutString);
        
        return timeOutString;
    }

}

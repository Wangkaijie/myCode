package com.travelzen.fare.galileo.shopping.config;

import org.slf4j.Logger;

import com.travelzen.framework.config.tops.TopsConfReader;
import com.travelzen.framework.config.tops.TopsConfEnum.ConfScope;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class ZooKeeperSvrConfig {
	private static Logger logger = RequestIdentityLogger.getLogger(ZooKeeperSvrConfig.class);

    private static final String ZOOKEEPER_SERVER_DIR = "properties/tops-fare-galileo-shopping.properties";

    private static final String SVRPORT = "service.port";
    private static final String SVRTHREADNUM = "service.threadNum";
    
    private static final String ZKNAME = "zookeeper.name";
    private static final String ZKPREFIX = "zookeeper.prefix";
    private static final String ZKSHARDID = "zookeeper.shardId";
    private static final String ZKREPLICAID = "zookeeper.replicaId";

    public static int getSvrPort() {
        int portInt = TopsConfReader.getConfContentForInt(ZOOKEEPER_SERVER_DIR, SVRPORT, ConfScope.M);
        logger.info("getSvrPort:" + portInt);
        return portInt;
    }
    
    public static int getSvrThreadNum() {
        int threadNum = TopsConfReader.getConfContentForInt(ZOOKEEPER_SERVER_DIR, SVRTHREADNUM, ConfScope.M);
        logger.info("getSvrThreadNum:" + threadNum);
        return threadNum;
    }

    public static String getZKName() {
        String serviceName = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, ZKNAME, ConfScope.M);
        logger.info("getZKName:" + serviceName);
        return serviceName;
    }

    public static String getZKPrefix() {
        String servicePath = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, ZKPREFIX, ConfScope.M);
        logger.info("getZKPrefix:" + servicePath);
        return servicePath;
    }

    public static String getZKShardId() {
        String sharedIdString = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, ZKSHARDID, ConfScope.M);
        logger.info("SharedId:" + sharedIdString);
        return sharedIdString;
    }

    public static String getZKReplicaId() {
        String replicaIdString = TopsConfReader.getConfContent(ZOOKEEPER_SERVER_DIR, ZKREPLICAID, ConfScope.M);
        logger.info("ReplicaId:" + replicaIdString);
        return replicaIdString;
    }

}

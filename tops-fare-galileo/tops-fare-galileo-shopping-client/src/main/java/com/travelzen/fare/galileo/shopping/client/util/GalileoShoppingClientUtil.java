package com.travelzen.fare.galileo.shopping.client.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.travelzen.fare.galileo.shopping.client.config.ZooKeeperClientConfig;
import com.travelzen.fare.galileo.shopping.service.GalileoShoppingService;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;

public class GalileoShoppingClientUtil {
	
private static Logger logger = RequestIdentityLogger.getLogger(GalileoShoppingClientUtil.class);
    
    private static Object locker = GalileoShoppingClientUtil.class;
    private static GalileoShoppingClientLoadBalancingChannel dataCenterStorageLoadBalancingChannel = null;

    public static GalileoShoppingService.Iface getClientInstance() throws Exception {
        if (dataCenterStorageLoadBalancingChannel == null) {
            createInstance();
        }
        return dataCenterStorageLoadBalancingChannel.proxy();
    }

    private static void createInstance() throws Exception {
//        IbeplusShoppingClientLoadBalancingChannel dataCenterStorageLoadBalancingChannel = null;
        synchronized (locker) {
            if (dataCenterStorageLoadBalancingChannel == null) {
                String ipPort = ZooKeeperClientConfig.getIp() + ":" + ZooKeeperClientConfig.getPort();
                List<String> ipList = new ArrayList<String>();

                ipList.add(ipPort);
                dataCenterStorageLoadBalancingChannel = new GalileoShoppingClientLoadBalancingChannel(ipList,
                        ZooKeeperClientConfig.getZKPath(), ZooKeeperClientConfig.getZKName(), true);
            }
        }
    }

}

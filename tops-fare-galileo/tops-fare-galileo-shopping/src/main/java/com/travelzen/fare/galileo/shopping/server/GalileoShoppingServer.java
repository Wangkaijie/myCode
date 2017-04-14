package com.travelzen.fare.galileo.shopping.server;

import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.slf4j.Logger;

import com.travelzen.fare.datacenter.common.GDSCommandEnum;
import com.travelzen.fare.datacenter.storage.DataCenterRecord;
import com.travelzen.fare.galileo.shopping.config.ZooKeeperSvrConfig;
import com.travelzen.fare.galileo.shopping.datacenterstorage.DataCenterStorageProcessThread;
import com.travelzen.fare.galileo.shopping.db.table.GalileoShoppingFareRuleTableCtrl;
import com.travelzen.fare.galileo.shopping.displayfarerule.GalileoShoppingDisplayFareRule;
import com.travelzen.fare.galileo.shopping.handler.GalileoShoppingServiceImpl;
import com.travelzen.fare.galileo.shopping.route.channel.GalileoShoppingRouteWriteTask;
import com.travelzen.fare.galileo.shopping.service.GalileoShoppingService;
import com.travelzen.fare.util.business.sync.SynchronousThread;
import com.travelzen.fare.util.common.auto.FareAutoIncMsg;
import com.travelzen.fare.util.common.cache.ShoppingRouteDBCache;
import com.travelzen.fare.util.common.queue.FareQueue;
import com.travelzen.fare.util.common.recover.FareRecoverEnum;
import com.travelzen.fare.util.common.recover.FareRecoverThread;
import com.travelzen.fare.util.common.time.FareDateTimeUtil;
import com.travelzen.framework.config.tops.util.TopsAppRegistry;
import com.travelzen.framework.config.tops.zk.TopsZookeeperBalancer;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.framework.metrics.InitMetricsReporter;
import com.travelzen.framework.thrift.protocol.RIThriftProtocolFactory;
import com.travelzen.tops.flight.cache.CabinDiscountCache;

public class GalileoShoppingServer {
	
private static Logger log = RequestIdentityLogger.getLogger(GalileoShoppingServer.class);
    
    private static FareAutoIncMsg fareAutoIncMsg = null;

    public static GalileoShoppingServiceImpl galileoShoppingServiceImpl = null;
    public static GalileoShoppingService.Processor<GalileoShoppingServiceImpl> processor = null;
    public static TThreadedSelectorServer server;
    public static ShoppingRouteDBCache cacheDataChannel=GalileoShoppingInit.getCacheInstance();
    public static void main(String[] args) throws Exception{
    	// 添加监控
    	InitMetricsReporter.startReporter();
        start();
    }

    public static void start() {
    	int i;
    	FareQueue<DataCenterRecord> dataCenterStorageTableQueue = new FareQueue<DataCenterRecord>();
    	
        try {
        	
        	galileoShoppingServiceImpl = new GalileoShoppingServiceImpl();
            processor = new GalileoShoppingService.Processor<GalileoShoppingServiceImpl>(galileoShoppingServiceImpl);
            
            Runnable simple = new Runnable() {
                public void run() {
                    task(processor, ZooKeeperSvrConfig.getSvrPort());
                }
            };
            
            new Thread(simple).start();
            
            CabinDiscountCache.getInstance();
            // 启动后台服务
            
           // fareAutoIncMsg = new FareAutoIncMsg(GalileoShoppingAutoIncTableCtrl.getInstance());
            
            SynchronousThread.startTask(GDSCommandEnum.GalileoShopping,cacheDataChannel, dataCenterStorageTableQueue);
        	
            for (i = 0; i < 5; i++) {
            	DataCenterStorageProcessThread.startTask(dataCenterStorageTableQueue);
            }
            
            GalileoShoppingRouteWriteTask.getInstance().start();
            
            FareRecoverThread thread = new FareRecoverThread();
            
            thread.addMongoDBCtrl(GalileoShoppingFareRuleTableCtrl.getInstance(), FareRecoverEnum.CurrentDate_TimeOff, 
            		GalileoShoppingDisplayFareRule._Fields.LAST_UPDATE_TIME.getFieldName(),
            		0 - FareDateTimeUtil.getMillisSecondsWithOneDay());
            thread.start();

        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        }
    }

    public static void stop() {
        try {
            if (server.isServing()) {
                server.stop();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void task(GalileoShoppingService.Processor<GalileoShoppingServiceImpl> processor, int port) {
        try {
            log.info("start FlightService server.");
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(port);
            TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(serverTransport).processor(processor);
            
            args.workerThreads(ZooKeeperSvrConfig.getSvrThreadNum());
            args.transportFactory(new TFramedTransport.Factory());
            args.inputProtocolFactory(new RIThriftProtocolFactory());
            args.outputProtocolFactory(new RIThriftProtocolFactory());
            server = new TThreadedSelectorServer(args);

            TopsZookeeperBalancer.registerRpc(TopsAppRegistry.getLocalIP() + ":" + port, ZooKeeperSvrConfig.getZKPrefix(), 
            		ZooKeeperSvrConfig.getZKName(), ZooKeeperSvrConfig.getZKShardId(), ZooKeeperSvrConfig.getZKReplicaId());
            log.info("Starting the Nonblocking server...");
            server.serve();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}

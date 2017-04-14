package com.travelzen.fare.galileo.shopping.route.channel;

import java.util.List;

import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.fare.util.common.channel.ChannelWriteData;

public class GalileoShoppingRouteWriteFactory {
	
private static GalileoShoppingRouteWriteTask writeTask = GalileoShoppingRouteWriteTask.getInstance();
	
	public static void saveRouteList(String queryKey, List<GalileoShoppingRoute> galileoShoppingRouteList) throws Exception {
		GalileoShoppingRouteWriteData galileoShoppingRouteWriteData = new GalileoShoppingRouteWriteData();
		ChannelWriteData routeWriteData = new ChannelWriteData();
		
		galileoShoppingRouteWriteData.setQueryKey(queryKey);
		galileoShoppingRouteWriteData.setGalileoShoppingRouteList(galileoShoppingRouteList);
		routeWriteData.setOpEnum(GalileoShoppingRouteWriteOpType.INSERTWITHQUERY);
		routeWriteData.setData(galileoShoppingRouteWriteData);
		
		writeTask.write(routeWriteData);
	}

}

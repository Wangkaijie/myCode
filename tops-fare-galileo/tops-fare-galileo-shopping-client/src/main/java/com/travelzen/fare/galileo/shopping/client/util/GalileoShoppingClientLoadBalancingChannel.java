package com.travelzen.fare.galileo.shopping.client.util;

import java.util.List;

import com.travelzen.fare.galileo.shopping.service.GalileoShoppingService;
import com.travelzen.fare.galileo.shopping.service.GalileoShoppingService.Iface;
import com.travelzen.framework.thrift.client.balancing.Client;
import com.travelzen.framework.thrift.client.balancing.LoadBalancingChannelNoProperty;
import com.travelzen.framework.thrift.client.balancing.WjThriftClient;

public class GalileoShoppingClientLoadBalancingChannel extends LoadBalancingChannelNoProperty<GalileoShoppingService.Iface> {

	public GalileoShoppingClientLoadBalancingChannel(List<String> list,
			String prefix, String serviceName, boolean needCache) {
		super(list, prefix, serviceName, needCache);
	}

	@Override
	public Client<Iface> createThriftCient(String ip, int port) {
		
        Client<GalileoShoppingService.Iface> tc = new WjThriftClient<GalileoShoppingService.Iface, GalileoShoppingService.Client>(
                ip, port, true, GalileoShoppingService.Client.class);
        return tc;
	}

}

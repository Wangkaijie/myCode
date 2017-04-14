package com.travelzen.fare.galileo.shopping.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.fare.galileo.shopping.server.GalileoShoppingInit;
import com.travelzen.framework.logger.core.ri.RequestIdentityLogger;
import com.travelzen.tops.fare.channel.CacheDataChannel;
import com.travelzen.tops.fare.channel.CacheStructure.CacheData;
import com.travelzen.tops.fare.channel.CacheStructure.CacheRecord;
import com.travelzen.tops.fare.framework.utils.SerializeUtils;

public class GalileoShoppingRouteDao {

	private static Logger log = RequestIdentityLogger.getLogger(GalileoShoppingRouteDao.class);
	private static CacheDataChannel cacheChannel = GalileoShoppingInit.getCacheInstance().getDataInstance();

	public static GalileoShoppingResponse getRoutesByQueryKey(String queryKey) {
		GalileoShoppingResponse galileoShoppingResponse = new GalileoShoppingResponse();
		List<GalileoShoppingRoute> routeList = null;
		CacheRecord record = cacheChannel.findByQueryKey(queryKey);

		if (record == null) {
			log.info("GalileoShopping 未查询到数据　querykey=" + queryKey);
			return null;
		}
		if (record.opt.error == null) {
			if (record.opt != null && record.opt.datas != null) {
				routeList = new ArrayList<GalileoShoppingRoute>();
				for (CacheData data : record.opt.datas) {
					GalileoShoppingRoute route = (GalileoShoppingRoute) SerializeUtils.Tdeserialize(data.content,
							GalileoShoppingRoute.class);
					routeList.add(route);
				}

			}
			galileoShoppingResponse.setGalileoShoppingRouteList(routeList);
		} else {
			GalileoShoppingErrorTable errorTable = new GalileoShoppingErrorTable();
			errorTable.setErrorCode(record.opt.error.code);
			errorTable.setErrorMsg(record.opt.error.msg);
			galileoShoppingResponse.setError(errorTable);
		}

		return galileoShoppingResponse;
	}

	public static List<GalileoShoppingRoute> getRoutesByRouteKeys(String routeKey) {

		CacheData data = cacheChannel.queryByRouteKey(routeKey);
		List<GalileoShoppingRoute> routeList = new ArrayList<>();

		if (data == null) {
			log.info("未查询到数据 queryKey ＝ " + routeKey);
			return routeList;
		}

		routeList.add((GalileoShoppingRoute) SerializeUtils.Tdeserialize(data.content, GalileoShoppingRoute.class));

		return routeList;
	}

	public static GalileoShoppingRoute getRoutesById(long id) {

		CacheData data = cacheChannel.findById(id);

		if (data == null) {
			log.info("未查询到数据 id ＝ " + id);
			return null;
		} else {
			return (GalileoShoppingRoute) SerializeUtils.Tdeserialize(data.content, GalileoShoppingRoute.class);
		}

	}
	
	public static void deleteByRouteKey(String routeKey){
		cacheChannel.deleteByRouteKey(routeKey);
	}
	
	public static void deleteByRouteId(long routeId){
		cacheChannel.deleteByRouteId(routeId);
	}
}

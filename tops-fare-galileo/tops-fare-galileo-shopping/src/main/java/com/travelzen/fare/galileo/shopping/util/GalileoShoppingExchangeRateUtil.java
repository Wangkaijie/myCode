package com.travelzen.fare.galileo.shopping.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import com.travelzen.etermface.client.data.EtermCmdClient;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute;
import com.travelzen.rosetta.eterm.common.pojo.EtermXsFscResponse;

public class GalileoShoppingExchangeRateUtil {

	private static double rate = 1.0;
	private static long updateTime = 0;

	public static GalileoShoppingResponse computeCNY(GalileoShoppingResponse galileoShoppingResponse) throws Exception {
		if (null == galileoShoppingResponse || galileoShoppingResponse.getGalileoShoppingRouteListSize() <= 0) {
			return galileoShoppingResponse;
		}
		setPrice(galileoShoppingResponse.getGalileoShoppingRouteList());
		return galileoShoppingResponse;
	}

	public static List<GalileoShoppingRoute> computeCNY(List<GalileoShoppingRoute> galileoShoppingRouteList) {
		return setPrice(galileoShoppingRouteList);
	}

	private static double formatDouble(int num, double data) {
		DecimalFormat dFormat = new DecimalFormat();
		dFormat.setMaximumFractionDigits(num);
		dFormat.setRoundingMode(RoundingMode.CEILING);
		String dataString = dFormat.format(data);
		return Double.valueOf(dataString);
	}

	private static List<GalileoShoppingRoute> setPrice(List<GalileoShoppingRoute> galileoShoppingRouteList) {

		int price = 0;
		int tax = 0;
		EtermXsFscResponse etermXsFscResponse = null;
		if (0 == updateTime || updateTime < GalileoShoppingTimeUtil.currentDateTime()) {
			etermXsFscResponse = EtermCmdClient.xsfsc("HKD");
			if (etermXsFscResponse.isSuccess() == true) {
				rate = formatDouble(4, etermXsFscResponse.getRate2CNY());
				updateTime = System.currentTimeMillis();
			}
		}
		for (GalileoShoppingRoute galileoShoppingRoute : galileoShoppingRouteList) {
			price = (int) Math.ceil(galileoShoppingRoute.getHkdPrice() * rate);
			tax = (int) Math.ceil(galileoShoppingRoute.getHkdTax() * rate);
			galileoShoppingRoute.setPrice(price);
			galileoShoppingRoute.setTax(tax);
			galileoShoppingRoute.setExchangeRate(String.valueOf(rate));
		}

		return galileoShoppingRouteList;
	}

}

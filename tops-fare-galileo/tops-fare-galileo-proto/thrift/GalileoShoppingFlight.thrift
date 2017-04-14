namespace java com.travelzen.fare.galileo.shopping.flight


struct GalileoShoppingFlightStopOver{
 1:optional string stopAirport,
}


struct GalileoShoppingFlight{

	//管理字段
	1:optional string flightKey,
	
	//业务字段
	21:optional string carrier,
	22:optional string flightNumber,
	
	25:optional string fromCity,
	26:optional string fromAirport,				//depAirport
	27:optional string fromDate,					//depTime的date部分
	28:optional string fromTime,					//depTime的time部分
	
	30:optional string toCity,
	31:optional string toAirport,					//arrAirport
	32:optional string toDate,					//arrTime的date部分
	33:optional string toTime,						//arrTime的time部分
	
	35:optional map<string,string> allCabinInfo,		//其他仓位信息
	36:optional list<GalileoShoppingFlightStopOver>  galileoShoppingFlightStopOverList,					//stopCities,
	37:optional string codeShare,					
	38:optional string bookingClass,         //cabin
	39:optional string equipType,        //aircraftCode
	40:optional string cabinClass,
	
	41:optional string duration,                //添加字段
	42:optional string seatLeft,				//剩余座位数目
	43:optional string marketAirlines,
	44:optional i32 farePrice,
	45:optional string operatorAirlines;
}
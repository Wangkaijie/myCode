namespace java com.travelzen.fare.galileo.shopping.route

include "GalileoShoppingCommon.thrift"
include "GalileoShoppingFlight.thrift"
include "GalileoShoppingDisplayFareRule.thrift"

typedef GalileoShoppingCommon.GalileoShoppingPriceType GalileoShoppingPriceType
typedef GalileoShoppingCommon.GalileoShoppingApplyType GalileoShoppingApplyType
typedef GalileoShoppingCommon.GalileoShoppingTaxType GalileoShoppingTaxType
typedef GalileoShoppingCommon.GalileoShoppingFareType GalileoShoppingFareType


struct GalileoShoppingProcess{
  1:optional string fromCity,					//出发城市
  2:optional string fromAirport,				//出发机场
  3:optional string fromDate,					//整个航程出发日期
  4:optional string fromTime,					//整个航程出发时间
  
  5:optional string toCity,					//到达城市
  6:optional string toAirport,					//到达机场
  7:optional string toDate,					//整个航程到达日期
  8:optional string toTime,					//整个航程到达时间
  

  
  15:optional list<GalileoShoppingFlight.GalileoShoppingFlight> galileoShoppingFlightList,//航程内的多个航段信息
}

struct GalileoShoppingRoute{
    //优化字段
	1:optional i64    id,
	2:optional i64 seqNo,
	
	3:optional string queryKey,			
    4:optional string routeKey,			
    
    5:optional i64 lastUpdateDateTime,
  	6:optional i64 spiderDateTime,
  
    7:optional i32 flightCount,			//航段总数
  8:optional string filingAirCompany,     //主航司

	//业务字段
	10:optional string data,
	12:optional i32 passengerNum,
	14:optional GalileoShoppingCommon.GalileoPassengerType passengerType,
	16:optional i32 price,
	17:optional i32 hkdPrice,
	18:optional i32 orgPrice,
	20:optional i32 tax,
	21:optional i32 hkdTax,
	22:optional i32 orgTax,
	23:optional string currency ="HKD",
	24:optional string exchangeRate,
	25:optional GalileoShoppingTaxType taxType,
	26:optional i32 priceType,
	28:optional i32 applyType,
	30:optional GalileoShoppingFareType fareType,
	
	32:optional list<GalileoShoppingProcess> galileoShoppingProcessList,
	34:optional GalileoShoppingDisplayFareRule.GalileoShoppingDisplayFareRule galileoShoppingDisplayFareRule,
	36:optional string galileoShoppingFareRuleRequest;           //退改签查询参数
	38:optional string galileoShoppingCabinVerify;				//验舱参数
	40:optional string galileoShoppingPriceVerify;				//验价参数
	41:optional string galileoShoppingPriceVerifyResponse;				//验价返回参数
	42:optional i64 sessionID,
	44:optional string source,
	46:optional string fareBasis,
}
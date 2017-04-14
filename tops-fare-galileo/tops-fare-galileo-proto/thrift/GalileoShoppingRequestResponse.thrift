namespace java com.travelzen.fare.galileo.shopping.requestresponse

include "GalileoShoppingCommon.thrift"
include "GalileoShoppingError.thrift"
include "GalileoShoppingRoute.thrift"

enum GalileoShoppingResponseStatusEnum {
    Fresh = 0,
    Valid = 1,
    InValid = 2,
}

struct GalileoShoppingRequestProcess {
    1: required string fromCity; //出发城市三字码，如：PEK
    2: required string toCity; //到达城市三字码，如：FRA
    3: required string fromDate; //去程日期，格式：yyyy-mm-dd，如：2013-05-31
}

struct GalileoShoppingRequest {
  1:required GalileoShoppingCommon.GalileoTripType tripType;
  
  3:optional GalileoShoppingCommon.GalileoCabinType cabinType;
  4:optional set<GalileoShoppingCommon.GalileoPassengerType> passengerTypeSet;

  5:optional list<GalileoShoppingRequestProcess> requestProcessList;
  
  13:optional string isDirectFlightOnly,
  14:optional list<string> permittedCarriers,
  15:optional list<string> prohibitedCarriers,
  16:optional i32 maxReturnRouteNum,        //MaxRecord
  17:optional string chargeAmt,
  18:optional string chargeBy,
  19:optional string source,
 // 20:optional string overridePCC,
  21:optional string sourceMarkUpBy,
  22:optional string SourceMarkUpAmt,
}

struct GalileoShoppingResponse {
  1:optional string id,
  2:optional list<GalileoShoppingRoute.GalileoShoppingRoute> GalileoShoppingRouteList,	//可用的旅行选择
  3:optional GalileoShoppingError.GalileoShoppingErrorTable error;		//错误信息
  
  4:optional string queryKey,							//根据查询条件获得的key值
  
  5:optional GalileoShoppingResponseStatusEnum galileoShoppingResponseStatusEnum, 
  
  6:optional string searchSource;						//查询结果来在cache，还是gds
}
namespace java com.travelzen.fare.galileo.shopping.displayfarerule

struct GalileoShoppingDisplayFareRule{
	1:required string id,							//jiujiu验价参数的MD5值
	2:optional i64 lastUpdateTime,     //更新时间
	
    11:optional string refund,				//退票规定
    12:optional string endorse,				//改签规定
    13:optional string baggage,				//行李额规定
    14:optional string other						//其他说明
}
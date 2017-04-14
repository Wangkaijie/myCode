namespace java com.travelzen.fare.galileo.shopping.common

enum GalileoPassengerType {
  ADT = 0,
  CHD = 1,
}

enum GalileoTripType {
  OW = 0,
  RT = 1,
}

enum GalileoCabinType {
  Y = 0,
  C = 1,
  F = 2,
  PY=3,  	//premiumEconomy
  PF=4,		//premiumFirst
}

enum GalileoShoppingPriceType{
	PLAINPRICE	=0,
	OVERSEASSTUDENTPRICE	=1,
}

enum GalileoShoppingApplyType{
	SCHEDULEDPRICE	=0,
	APPLIEDPRICE	=1,
}

enum GalileoShoppingTaxType{
	EXCLUDINGTAX	=0,
	INCLUDINGTAX	=1,
}

enum GalileoShoppingFareType{
	CONSOLEFARE	=0,
	PUBLISHEDFARE	=1,
}
package com.travelzen.fare.galileo.shopping.util;

import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponse;
import com.travelzen.fare.galileo.shopping.requestresponse.GalileoShoppingResponseStatusEnum;


public class GalileoShoppingUtil {
	
	public static boolean isSuccess(GalileoShoppingResponse galileoShoppingResponse){
   	 	if (galileoShoppingResponse != null) {
   	 		if (galileoShoppingResponse.isSetError() == true) {
   	 			return true;
   	 		}
   	 		
   	 		if (galileoShoppingResponse.isSetGalileoShoppingRouteList() == true &&
   	 			galileoShoppingResponse.getGalileoShoppingRouteListSize() > 0) {
     			return true;
   	 		}
        }
   	
   	 	return false;
    }
	public static boolean isEmpty(GalileoShoppingResponse galileoShoppingResponse){
    	if(galileoShoppingResponse==null){
    		return true;
    	}
    	if(!galileoShoppingResponse.isSetGalileoShoppingRouteList()&&!galileoShoppingResponse.isSetError()){
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean isNotFresh(GalileoShoppingResponse galileoShoppingResponse){
    	 if(galileoShoppingResponse.getGalileoShoppingResponseStatusEnum()==null){
    		 return true;
    	 }
    	if(galileoShoppingResponse.getGalileoShoppingResponseStatusEnum()!=GalileoShoppingResponseStatusEnum.Fresh){
    		return true;
    	}
    	return false;
    }
	
 public static boolean isBreak(GalileoShoppingResponse galileoShoppingResponse){
    	
    	if(galileoShoppingResponse!=null){
    		if(galileoShoppingResponse.getGalileoShoppingResponseStatusEnum()!=null){
    			if(galileoShoppingResponse.getGalileoShoppingResponseStatusEnum()!=GalileoShoppingResponseStatusEnum.InValid){
    				return true;
    			}else{
    				return false;
    			}
    		}else{
    			if(galileoShoppingResponse.getError()!=null){
    				return true;
    			}
    		}
    	}
    	
    
   	
   	 	return false;
    }
    
	
}

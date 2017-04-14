package com.travelzen.fare.galileo.convertor.flight;

import java.util.ArrayList;
import java.util.List;

import com.travelzen.flight.api.galileo.bean.GalileoSegment;
import com.travelzen.flight.api.galileo.pojo.Segment;

public class SegmentsToGalileoSegmentsConvertor {
	
	public static List<GalileoSegment> segmentsToGalileoSegments(List<Segment> segments)throws Exception{
		List<GalileoSegment> galileoSegmentList = new ArrayList<GalileoSegment>();
		if(null != segments && segments.size()>0){
			for(Segment segment : segments){
				galileoSegmentList.add(segmentToGalileoSegment(segment));
			}
		}
		return galileoSegmentList;
	}
	
	
	public static GalileoSegment segmentToGalileoSegment(Segment segment)throws Exception{
		GalileoSegment galileoSegment = null;
		if(null != segment){
			galileoSegment = new GalileoSegment();
			galileoSegment.setAircraftCode(segment.getAircraftCode());
			galileoSegment.setAirReminder(segment.getAirReminder());
			galileoSegment.setAirTime(segment.getAirTime());
			galileoSegment.setArrAirport(segment.getArrAirport());
			galileoSegment.setArrTime(segment.getArrTime());
			galileoSegment.setBookingcodeinfo(segment.getBookingcodeinfo());
			galileoSegment.setCabin(segment.getCabin());
			galileoSegment.setCarrier(segment.getCarrier());
			galileoSegment.setCodeShare(segment.isCodeShare());
			galileoSegment.setDepAirport(segment.getDepAirport());
			galileoSegment.setDepTime(segment.getDepTime());
			galileoSegment.setFarePrice(segment.getFarePrice());
			galileoSegment.setFlightNumber(segment.getFlightNumber());
			galileoSegment.setKey(segment.getKey());
			galileoSegment.setMarketAirlines(segment.getMarketAirlines());
			galileoSegment.setOperatorAirlines(segment.getOperatorAirlines());
			galileoSegment.setStopCities(segment.getStopCities());
		}
		
		return galileoSegment;
	}

}

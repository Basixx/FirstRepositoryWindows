package com.kodilla.exception.test;

import com.kodilla.exception.index.IndexExceptionRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private Map<String, Boolean> flightExamples = new HashMap<>();

    public FlightFinder(){
        flightExamples.put("Berlin", true);
        flightExamples.put("Rome", true);
        flightExamples.put("Madrid", true);
        flightExamples.put("Paris", true);
        flightExamples.put("Tokyo", false);
        flightExamples.put("Chicago", false);
        flightExamples.put("Montreal", false);
        flightExamples.put("Seul", false);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException{
        Boolean flights = flightExamples.get(flight.getArrivalAirport());
        if (flights != null){
            if (flights){
                System.out.println("Flight found");
            } else {
                System.out.println("No flights to this destination found");
            }
        } else {
            throw new RouteNotFoundException("No such destination on map");
        }
    }
}

package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Warsaw", "Rome");
        Flight flight2 = new Flight("Warsaw", "Tokyo");
        Flight flight3 = new Flight("Warsaw", "Vienna");

        try {
            flightFinder.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("No such flight, error: " + e);
        }

        try {
            flightFinder.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println("No such flight, error: " + e);
        }

        try {
            flightFinder.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("No such flight found, error: " + e);
        }
    }
}


package com.kodilla.exception.test;

public class FlightApp {
    public static void main(String[] args) {
        FlightDatabase flightDatabase = new FlightDatabase();

        Flight flight = new Flight("Stockholm", "Saint Petersburg");
        Flight nextFlight = new Flight("Copenhagen", "Skopie");

        try {
            flightDatabase.findFlight(flight);
            flightDatabase.findFlight(nextFlight);
        } catch (RouteNotFoundException e) {
            System.out.println("Flight doesn't exist");
        }
    }
}

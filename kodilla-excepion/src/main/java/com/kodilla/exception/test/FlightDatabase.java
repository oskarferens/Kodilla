package com.kodilla.exception.test;
import java.util.HashMap;
import java.util.Map;

public class FlightDatabase {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> destinationList = new HashMap<>();

        destinationList.put("Stockholm", true);
        destinationList.put("London", true);
        destinationList.put("Copenhagen", false);
        destinationList.put("Geneva", false);
        destinationList.put("Saint Petersburg", true);
        destinationList.put("Cracow", true);
        destinationList.put("Skopie", false);

        if (destinationList.containsKey(flight.getArrivalAirport())) {
            System.out.println("Flight to: " + flight.getArrivalAirport() + " exist");
        } else {
            throw new RouteNotFoundException("Flight doesn't exist!");
        }
    }
}
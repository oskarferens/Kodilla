package com.kodilla.exception.test;
import java.util.HashMap;
import java.util.Map;

public class FlightDatabase {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> destinationList = new HashMap<>();

        destinationList.put("Stockholm", true);
        destinationList.put("London", true);
        destinationList.put("Copenhagen", false);
        destinationList.put("Geneva", false);
        destinationList.put("Saint Petersburg", true);
        destinationList.put("Cracow", true);
        destinationList.put("Skopie", false);

        if (destinationList.containsKey(flight.getArrivalAirport())) {
            return destinationList.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("Flight doesn't exist!");
        }
    }
}

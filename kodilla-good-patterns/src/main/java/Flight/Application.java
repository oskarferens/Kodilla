package Flight;

public class Application {

    public static void main(String[] args) {
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        flightSearchEngine.searchDepartureFromAirport("Gdańsk");
        flightSearchEngine.searchToArrivalAirport("Wrocław");
        flightSearchEngine.searchWithStopoverFlight("Kraków", "Wrocław", "Gdańsk");
    }
}
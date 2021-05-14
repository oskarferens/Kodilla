package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
//        MovieStore movieStore = new MovieStore();
//
//        String result = movieStore.getMovies().values().stream()
//                .flatMap(strings -> strings.stream())
//                .collect(Collectors.joining("!"));
//        System.out.println(result);
//

        Order order = new Order("Kuboty",1);
        OrderProcessor orderProcessor = orderProcessor(
                new EmailInformationService(), new AllegroOrderRealizer(), new DbOrderRepository());

        orderProcessor.processOrder(order);
    }
}

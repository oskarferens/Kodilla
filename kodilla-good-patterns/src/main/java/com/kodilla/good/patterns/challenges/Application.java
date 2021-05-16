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
        SampleOrder sampleOrder = new SampleOrder();
        OrderRequest orderRequest = sampleOrder.request();
        OrderProcessor orderProcessor = new OrderProcessor(new ConfirmService(),
                new ProductOrderService(), new ProductOrderRepo());
        orderProcessor.process(orderRequest);
    }
}

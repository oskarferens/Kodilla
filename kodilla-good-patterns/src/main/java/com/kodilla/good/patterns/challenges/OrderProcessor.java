package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private InformationService informationService;
    private OrderRealiser orderRealiser;
    private OrderRepository orderRepository;

    OrderProcessor(
            InformationService informationService,
            OrderRealiser orderRealiser,
            OrderRepository orderRepository) {
     this.informationService = informationService;
     this.orderRealiser = orderRealiser;
     this.orderRepository = orderRepository;
    }

    public boolean processOrder(Order order) {
        boolean result = orderRealiser.processOrder(order);
        if (result) {
            informationService.inform("Your order has been processed");
        } else {
            informationService.inform("Your order can not be processed");
        }
        orderRepository.storeOrder(order,result);
        return result;
    }
}

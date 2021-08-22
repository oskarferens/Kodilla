package com.kodilla.patterns2.good.patterns.challenges;

public class ConfirmService implements InformationService {
    @Override
    public void sendMessage(User user) {
        System.out.println("An order confirmation e-mail has been sent to the address provided");
    }
}
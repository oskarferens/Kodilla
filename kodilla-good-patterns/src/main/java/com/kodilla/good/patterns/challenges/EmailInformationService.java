package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService{
    @Override
    public void inform(String message) {
        System.out.println("Email: " + message);
    }
}

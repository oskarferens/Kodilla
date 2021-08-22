package com.kodilla.patterns2.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(final String message) {
        super(message);
    }
}
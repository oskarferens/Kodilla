package com.kodilla.patterns2.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {
    public void displayValue(double val){
        System.out.println(val);
    }
}

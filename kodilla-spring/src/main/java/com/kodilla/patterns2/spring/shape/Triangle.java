package com.kodilla.patterns2.spring.shape;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

    @Override
    public String getShapeName() {
        return "This is a triangle.";
    }
}
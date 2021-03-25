package com.kodilla.testing.shape;

public class Circle implements Shape {

    double r;

    public Circle (double r) {
        this.r = r;
    }

    @Override
    public String getFigureName() {
        return "circle";
    }

    @Override
    public Double getArea() {
        return Math.PI * r * r;
    }
}

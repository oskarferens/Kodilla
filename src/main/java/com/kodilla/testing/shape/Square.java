package com.kodilla.testing.shape;

public class Square implements Shape{

    double a;
    public Square (double a) {
        this.a = a;
    }

    @Override
    public String getFigureName() {
        return "square";
    }

    @Override
    public Double getArea() {
        return a*a;
    }
}

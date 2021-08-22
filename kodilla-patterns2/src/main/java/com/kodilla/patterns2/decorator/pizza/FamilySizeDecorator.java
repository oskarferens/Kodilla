package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class FamilySizeDecorator extends AbstractPizzaOrderDecorator {
    public FamilySizeDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + family size (50cm)";
    }
}

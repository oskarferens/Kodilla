package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.pizza.sauce.GarlicSauceDecorator;
import com.kodilla.patterns2.decorator.pizza.sauce.KetchupDecorator;
import com.kodilla.patterns2.decorator.pizza.toppings.HamDecorator;
import com.kodilla.patterns2.decorator.pizza.toppings.OnionDecorator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Standard pizza", description);
    }

    @Test
    public void testFamilyPizzaWithSauceAndToppingsGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new FamilySizeDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(31), theCost);
    }

    @Test
    public void testFamilyPizzaWithSauceFatCrustAndToppingsDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new FamilySizeDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new KetchupDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Standard pizza + family size (50cm) + garlic sauce + ham + ketchup", description);
    }
}

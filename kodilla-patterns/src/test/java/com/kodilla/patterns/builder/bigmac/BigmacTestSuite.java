package com.kodilla.patterns.builder.bigmac;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("bun with sesame")
                .burgers(1)
                .sauce("BBQ sauce")
                .ingredient("cheese")
                .ingredient("cucumber")
                .ingredient("onion")
                .ingredient("lettuce")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(4, howManyIngredients);
    }
}

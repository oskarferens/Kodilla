package com.kodilla.patterns2.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShapesFactory {

    @Bean
    public Square createSquare() {
        return new Square();
    }
}
package com.kodilla.patterns2.patterns.strategy.social;

import com.kodilla.patterns2.patterns.strategy.social.publishers.FacebookPublisher;

public class Millennials extends User {

    public Millennials(String userName) {
        super(userName);
        this.socialPublisher = new FacebookPublisher();
    }
}
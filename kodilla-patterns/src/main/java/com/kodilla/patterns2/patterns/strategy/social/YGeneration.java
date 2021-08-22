package com.kodilla.patterns2.patterns.strategy.social;

import com.kodilla.patterns2.patterns.strategy.social.publishers.TwitterPublisher;

public class YGeneration extends User {

    public YGeneration(String userName) {
        super(userName);
        this.socialPublisher = new TwitterPublisher();
    }
}
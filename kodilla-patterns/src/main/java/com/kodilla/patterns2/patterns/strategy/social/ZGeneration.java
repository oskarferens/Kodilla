package com.kodilla.patterns2.patterns.strategy.social;

import com.kodilla.patterns2.patterns.strategy.social.publishers.SnapchatPublisher;

public class ZGeneration extends User {

    public ZGeneration(String userName) {
        super(userName);
        this.socialPublisher = new SnapchatPublisher();
    }
}
package com.kodilla.patterns2.patterns.strategy.social.publishers;

import com.kodilla.patterns2.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "Twitter";
    }
}
package com.kodilla.patterns2.patterns.strategy.social.publishers;

import com.kodilla.patterns2.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "Facebook";
    }
}

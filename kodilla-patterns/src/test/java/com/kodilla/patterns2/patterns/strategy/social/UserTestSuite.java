package com.kodilla.patterns2.patterns.strategy.social;

import com.kodilla.patterns2.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User john = new Millennials("John Kowalski");
        User mary = new YGeneration("Mary Nowak");
        User abdullah = new ZGeneration("Abdullah Yalla");

        //When
        String johnsCommunicator = john.sharePost();
        System.out.println("John uses: " + johnsCommunicator);
        String marysCommunicator = mary.sharePost();
        System.out.println("Mary uses: " + marysCommunicator);
        String abdullahsCommunicator = abdullah.sharePost();
        System.out.println("Abdullah uses: " + abdullahsCommunicator);

        //Then
        assertEquals("Facebook", johnsCommunicator);
        assertEquals("Twitter", marysCommunicator);
        assertEquals("Snapchat", abdullahsCommunicator);

    }

    @Test
    void testIndividualSharingStrategies() {
        //Given
        User john = new Millennials("John Kowalski");

        //When
        john.sharePost();
        john.setPublisher(new TwitterPublisher());

        //Then
        assertEquals("Twitter", john.sharePost());

    }
}

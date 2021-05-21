package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ForumUserTestSuite  {
    @Test
    void testGetUserName() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser forumUser = context.getBean(ForumUser.class);

        //When
        String result = forumUser.username;

        //Then
        assertEquals("John Smith", result);
        assertNotEquals("Horace Smith", result);
    }
}

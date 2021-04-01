package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatTest {
    @BeforeEach
    public void before() {
        System.out.println("Test case starts.");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case ends.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests done.");
    }

    @Test
    public void test0Posts() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class); //to w nawiasie to kontrakt

        when(statisticsMock.postsCount()).thenReturn(0);  //nieskonfigurowany mock zwraca puste wartosci
        when(statisticsMock.commentsCount()).thenReturn(10);

        List<String> userList = new ArrayList<>();
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, calculator.getNumberOfPosts());
        assertEquals(10, calculator.getNumberOfComments());
        assertEquals(3, calculator.getNumberOfUsers());
        assertEquals(0, calculator.getCommentsPerPost());
        assertEquals(0, calculator.getPostsPerUser());
        assertEquals(3.33, calculator.getCommentsPerUser(), 0.01);
    }
    @Test
    public void test1000Posts() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class); //to w nawiasie to kontrakt

        when(statisticsMock.postsCount()).thenReturn(1000);  //nieskonfigurowany mock zwraca puste wartosci
        when(statisticsMock.commentsCount()).thenReturn(10);

        List<String> userList = new ArrayList<>();
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, calculator.getNumberOfPosts());
        assertEquals(10, calculator.getNumberOfComments());
        assertEquals(3, calculator.getNumberOfUsers());
        assertEquals(0, calculator.getCommentsPerPost());  //Number of posts/comments per posts=expected dla tej assercji
        assertEquals(0, calculator.getPostsPerUser());
        assertEquals(3.33, calculator.getCommentsPerUser(), 0.01);
    }

}

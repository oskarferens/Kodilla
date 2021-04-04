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
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(0);
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
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        List<String> userList = new ArrayList<>();
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, calculator.getNumberOfPosts());
        assertEquals(0, calculator.getNumberOfComments());
        assertEquals(3, calculator.getNumberOfUsers());
        assertEquals(0, calculator.getCommentsPerPost());
        assertEquals(0.003, calculator.getPostsPerUser());// bo na liscie jest 3 userow 1000/3 ~ 0.003
        assertEquals(0, calculator.getCommentsPerUser());
    }

    @Test
    public void test0Comments() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);
        List<String> userList = new ArrayList<>();
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(10, calculator.getNumberOfPosts());
        assertEquals(10, calculator.getNumberOfComments());
        assertEquals(3, calculator.getNumberOfUsers());
        assertEquals(1, calculator.getCommentsPerPost());
        assertEquals(0.3, calculator.getPostsPerUser()); // 3 userow, 10 postow = 0,3
        assertEquals(0.3, calculator.getCommentsPerUser()); // 3 userow, 10 postow = 0,3
    }

    @DisplayName("Tests what if there are more posts than comments.")
    @Test
    public void testLessCommants() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(5);
        List<String> userList = new ArrayList<>();
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(10, calculator.getNumberOfPosts());
        assertEquals(5, calculator.getNumberOfComments());
        assertEquals(3, calculator.getNumberOfUsers());
        assertEquals(0.5, calculator.getCommentsPerPost());
        assertEquals(0.3, calculator.getPostsPerUser());
        assertEquals(0.3, calculator.getCommentsPerUser());
    }

    @DisplayName("Tests what if there are more comments than posts.")
    @Test
    public void testMoreCommants() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(2);
        when(statisticsMock.commentsCount()).thenReturn(10);
        List<String> userList = new ArrayList<>();
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(2, calculator.getNumberOfPosts());
        assertEquals(10, calculator.getNumberOfComments());
        assertEquals(3, calculator.getNumberOfUsers());
        assertEquals(5, calculator.getCommentsPerPost());
        assertEquals(1.5, calculator.getPostsPerUser());
        assertEquals(1.5, calculator.getCommentsPerUser());
    }

    @DisplayName("Tests if total users == 0")
    @Test
    public void test0Users() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class); //to w nawiasie to kontrakt
        when(statisticsMock.postsCount()).thenReturn(2);  //nieskonfigurowany mock zwraca puste wartosci
        when(statisticsMock.commentsCount()).thenReturn(10);
        List<String> userList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(2, calculator.getNumberOfPosts());
        assertEquals(10, calculator.getNumberOfComments());
        assertEquals(0, calculator.getNumberOfUsers());
        assertEquals(5, calculator.getCommentsPerPost());
        assertEquals(0, calculator.getPostsPerUser());
        assertEquals(0, calculator.getCommentsPerUser());
    }

    @Test
    public void test100Users() {
        //Given
        StatCalc calculator = new StatCalc();
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(10);
        List<String> userList = new ArrayList<>();
        for (int i=0; i< 100; i++){
            userList.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(userList);
        //When
        calculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(50, calculator.getNumberOfPosts());
        assertEquals(10, calculator.getNumberOfComments());
        assertEquals(100, calculator.getNumberOfUsers());
        assertEquals(0.2, calculator.getCommentsPerPost());
        assertEquals(2, calculator.getPostsPerUser());
        assertEquals(2, calculator.getCommentsPerUser());
    }
}

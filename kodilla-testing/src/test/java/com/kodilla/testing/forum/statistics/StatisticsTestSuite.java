package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("When 0 Posts")
    @Test
    void testCalculateWhen0Posts() {
        //given
        int postsCount = 0;
        int commentsCount = 0;
        List<String> usersCount = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            usersCount.add("user" + i);
        }



        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();

        //then
        Assertions.assertEquals(100, countStatistics.usersQuantity);
        Assertions.assertEquals(0, countStatistics.postsQuantity);
        Assertions.assertEquals(0, countStatistics.commentsQuantity);
        Assertions.assertEquals(0, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerPost, 0.01);

    }

    @DisplayName("When 1000 Posts")
    @Test
    void testCalculateWhen1000Posts() {
        //given
        int postsCount = 1000;
        int commentsCount = 3000;
        List<String> usersCount = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            usersCount.add("user" + i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersCount);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(1000, countStatistics.postsQuantity);
        Assertions.assertEquals(3000, countStatistics.commentsQuantity);
        Assertions.assertEquals(4, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(12, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(3, countStatistics.averageCommentsPerPost, 0.01);
    }

    @DisplayName("When 0 comments")
    @Test
    void testCalculateWhen0Comments() {
        //given
        int postsCount = 1000;
        int commentsCount = 0;
        List<String> usersCount = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            usersCount.add("user" + i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersCount);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(1000, countStatistics.postsQuantity);
        Assertions.assertEquals(0, countStatistics.commentsQuantity);
        Assertions.assertEquals(4, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerPost, 0.01);
    }

    @DisplayName("When more posts than comments")
    @Test
    void testCalculateWhenMorePosts() {
        //given
        int postsCount = 6000;
        int commentsCount = 3000;
        List<String> usersCount = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            usersCount.add("user" + i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersCount);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(6000, countStatistics.postsQuantity);
        Assertions.assertEquals(3000, countStatistics.commentsQuantity);
        Assertions.assertEquals(24, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(12, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(0.5, countStatistics.averageCommentsPerPost, 0.01);
    }

    @DisplayName("When more comments than posts")
    @Test
    void testCalculateWhenMoreComments() {
        //given
        int postsCount = 1000;
        int commentsCount = 1500;
        List<String> usersCount = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            usersCount.add("user" + i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersCount);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(1000, countStatistics.postsQuantity);
        Assertions.assertEquals(1500, countStatistics.commentsQuantity);
        Assertions.assertEquals(4, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(6, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(1.5, countStatistics.averageCommentsPerPost, 0.01);
    }

    @DisplayName("When 0 users")
    @Test
    void testCalculateWhen0Users() {
        //given
        int postsCount = 150;
        int commentsCount = 150;
        List<String> usersCount = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersCount.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersCount);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(100, countStatistics.usersQuantity);
        Assertions.assertEquals(150, countStatistics.postsQuantity);
        Assertions.assertEquals(150, countStatistics.commentsQuantity);
        Assertions.assertEquals(1.5, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(1.5, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(1, countStatistics.averageCommentsPerPost, 0.01);
    }

    @DisplayName("When 100 users")
    @Test
    void testCalculateWhen100Users() {
        //given
        int postsCount = 10;
        int commentsCount = 20;
        List<String> usersCount = new ArrayList<>();


        when(statisticsMock.usersNames()).thenReturn(usersCount);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(0, countStatistics.usersQuantity);
        Assertions.assertEquals(10, countStatistics.postsQuantity);
        Assertions.assertEquals(20, countStatistics.commentsQuantity);
        Assertions.assertEquals(0, countStatistics.averagePostsPerUser, 0.01);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerUser, 0.01);
        Assertions.assertEquals(2, countStatistics.averageCommentsPerPost, 0.01);
    }
}

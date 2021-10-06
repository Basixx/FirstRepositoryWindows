package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.CountStatistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @DisplayName("When 0 Posts")
    @Test
    void testCalculateWhen0Posts(){
        //given
        int postsAmmount = 0;
        int commentsAmmount = 0;
        List <String> usersAmmount = new ArrayList<>();

        for (int i=0; i<100; i++){
            usersAmmount.add("user"+i);
        }

        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();

        //then
        Assertions.assertEquals(100, countStatistics.usersQuantity);
        Assertions.assertEquals(0, countStatistics.postsQuantity);
        Assertions.assertEquals(0, countStatistics.commentsQuantity);
        Assertions.assertEquals(0, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerPost);

    }

    @DisplayName("When 1000 Posts")
    @Test
    void testCalculateWhen1000Posts(){
        //given
        int postsAmmount = 1000;
        int commentsAmmount = 3000;
        List <String> usersAmmount = new ArrayList<>();
        for (int i=0; i<250; i++){
            usersAmmount.add("user"+i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(1000, countStatistics.postsQuantity);
        Assertions.assertEquals(3000, countStatistics.commentsQuantity);
        Assertions.assertEquals(4, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(12, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(3, countStatistics.averageCommentsPerPost);
    }

    @DisplayName("When 0 comments")
    @Test
    void testCalculateWhen0Comments(){
        //given
        int postsAmmount = 1000;
        int commentsAmmount = 0;
        List <String> usersAmmount = new ArrayList<>();
        for (int i=0; i<250; i++){
            usersAmmount.add("user"+i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(1000, countStatistics.postsQuantity);
        Assertions.assertEquals(0, countStatistics.commentsQuantity);
        Assertions.assertEquals(4, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerPost);
    }

    @DisplayName("When more posts than comments")
    @Test
    void testCalculateWhenMorePosts(){
        //given
        int postsAmmount = 6000;
        int commentsAmmount = 3000;
        List <String> usersAmmount = new ArrayList<>();
        for (int i=0; i<250; i++){
            usersAmmount.add("user"+i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(6000, countStatistics.postsQuantity);
        Assertions.assertEquals(3000, countStatistics.commentsQuantity);
        Assertions.assertEquals(24, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(12, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(0.5, countStatistics.averageCommentsPerPost);
    }

    @DisplayName("When more comments than posts")
    @Test
    void testCalculateWhenMoreComments(){
        //given
        int postsAmmount = 1000;
        int commentsAmmount = 1500;
        List <String> usersAmmount = new ArrayList<>();
        for (int i=0; i<250; i++){
            usersAmmount.add("user"+i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(250, countStatistics.usersQuantity);
        Assertions.assertEquals(1000, countStatistics.postsQuantity);
        Assertions.assertEquals(1500, countStatistics.commentsQuantity);
        Assertions.assertEquals(4, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(6, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(1.5, countStatistics.averageCommentsPerPost);
    }

    @DisplayName("When 0 users")
    @Test
    void testCalculateWhen0Users(){
        //given
        int postsAmmount = 10;
        int commentsAmmount = 20;
        List <String> usersAmmount = new ArrayList<>();
        for (int i=0; i<100; i++){
            usersAmmount.add("user"+i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(100, countStatistics.usersQuantity);
        Assertions.assertEquals(150, countStatistics.postsQuantity);
        Assertions.assertEquals(150, countStatistics.commentsQuantity);
        Assertions.assertEquals(1.5, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(1.5, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(1, countStatistics.averageCommentsPerPost);
    }

    @DisplayName("When 100 users")
    @Test
    void testCalculateWhen100Users(){
        //given
        int postsAmmount = 10;
        int commentsAmmount = 20;
        List <String> usersAmmount = new ArrayList<>();


        when(statisticsMock.usersNames()).thenReturn(usersAmmount);
        when(statisticsMock.postsCount()).thenReturn(postsAmmount);
        when(statisticsMock.commentsCount()).thenReturn(commentsAmmount);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //when
        countStatistics.calculateAdvStatistics();
        //then
        Assertions.assertEquals(0, countStatistics.usersQuantity);
        Assertions.assertEquals(10, countStatistics.postsQuantity);
        Assertions.assertEquals(20, countStatistics.commentsQuantity);
        Assertions.assertEquals(0, countStatistics.averagePostsPerUser);
        Assertions.assertEquals(0, countStatistics.averageCommentsPerUser);
        Assertions.assertEquals(2, countStatistics.averageCommentsPerPost);
    }
}

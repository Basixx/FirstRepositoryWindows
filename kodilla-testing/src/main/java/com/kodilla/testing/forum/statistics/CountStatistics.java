package com.kodilla.testing.forum.statistics;

import java.util.List;

public class CountStatistics {
    private Statistics statistics;

    public CountStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    int usersQuantity;
    int postsQuantity;
    int commentsQuantity;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public void calculateAdvStatistics(){
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        if (statistics.usersNames().size() != 0){
            averagePostsPerUser = statistics.postsCount()/statistics.usersNames().size();
            averageCommentsPerUser = statistics.commentsCount()/statistics.usersNames().size();
        }
        else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (statistics.postsCount() != 0){
            averageCommentsPerPost = statistics.commentsCount()/statistics.postsCount();
        }
        else {
            averageCommentsPerPost = 0;
        }
    }


    public void showStatistics(){
        System.out.println("Number of Users: "+ usersQuantity);
        System.out.println("Number of Posts: " + postsQuantity);
        System.out.println("Number of Comments: "+ commentsQuantity);
        System.out.println("Number of Posts per User: "+ averagePostsPerUser);
        System.out.println("Number of Comments per User: "+averageCommentsPerUser);
        System.out.println("Number of Comments per Post: "+averageCommentsPerPost);
    }



}

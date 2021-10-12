package com.kodilla.testing.forum.statistics;

public class CountStatistics {
    private Statistics statistics;

    int usersQuantity;
    int postsQuantity;
    int commentsQuantity;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public CountStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics() {
        usersQuantity = statistics.usersNames().size();
        postsQuantity =  statistics.postsCount();
        commentsQuantity =  statistics.commentsCount();
        if (statistics.usersNames().size() != 0) {
            averagePostsPerUser = (double) statistics.postsCount() / statistics.usersNames().size();
            averageCommentsPerUser = (double) statistics.commentsCount() / statistics.usersNames().size();
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (statistics.postsCount() != 0) {
            averageCommentsPerPost = (double) statistics.commentsCount() / statistics.postsCount();
        } else {
            averageCommentsPerPost = 0;
        }
    }


    public void showStatistics() {
        System.out.println("Number of Users: " + usersQuantity);
        System.out.println("Number of Posts: " + postsQuantity);
        System.out.println("Number of Comments: " + commentsQuantity);
        System.out.println("Number of Posts per User: " + averagePostsPerUser);
        System.out.println("Number of Comments per User: " + averageCommentsPerUser);
        System.out.println("Number of Comments per Post: " + averageCommentsPerPost);
    }


}

package com.kodilla.patterns.strategy.social.publishers;

public class FacebookPublisher implements SocialPublisher{
    public String share(){
        return " posted on facebook";
    }
}

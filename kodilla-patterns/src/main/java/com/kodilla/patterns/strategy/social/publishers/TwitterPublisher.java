package com.kodilla.patterns.strategy.social.publishers;

public class TwitterPublisher implements SocialPublisher{
    public String share(){
        return " posted on twitter";
    }
}

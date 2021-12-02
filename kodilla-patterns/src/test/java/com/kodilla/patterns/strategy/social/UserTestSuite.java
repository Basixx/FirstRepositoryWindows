package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {
    @Test
    void testDefaultPublishers(){
        //given
        User mike = new Millenials("Mike");
        User jacob = new YGeneration("Jacob");
        User natalie = new ZGeneration("Natalie");

        //when
        String mikeShare = mike.publish();
        System.out.println(mike.getUserName() + mikeShare);
        String jacobShare = jacob.publish();
        System.out.println(jacob.getUserName() + jacobShare);
        String natalieShare = natalie.publish();
        System.out.println(natalie.getUserName() + natalieShare);

        //then
        assertEquals(" posted on facebook", mikeShare);
        assertEquals(" posted on twitter", jacobShare);
        assertEquals(" posted on snapchat", natalieShare);
    }

    @Test
    void testIndividualPublisher(){
        //given
        User richard = new ZGeneration("Richard");

        //when
        String richardShare = richard.publish();
        System.out.println(richard.getUserName() + richardShare);
        richard.setSocialPublisher(new FacebookPublisher());
        richardShare = richard.publish();
        System.out.println(richard.getUserName() +" now"+ richardShare);

        //then
        assertEquals(" posted on facebook", richardShare);
    }
}

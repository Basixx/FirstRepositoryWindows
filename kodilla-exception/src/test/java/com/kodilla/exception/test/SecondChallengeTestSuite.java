package com.kodilla.exception.test;

import static org.junit.jupiter.api.Assertions.*;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

public class SecondChallengeTestSuite {

    @Test
   void testProbablyWillThrowException(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then

        assertAll(
                //when both numbers are correct
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5)),
                //when x is incorrect and y is correct
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 0)),
                //when x is corret and y is incorrect
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),
                //when both numbers are incorrect
                () -> assertDoesNotThrow(()-> secondChallenge.probablyIWillThrowException(1.5, 2))

        );

    }
}

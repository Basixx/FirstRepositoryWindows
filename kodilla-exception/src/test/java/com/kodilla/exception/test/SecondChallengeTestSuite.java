package com.kodilla.exception.test;

import static org.junit.jupiter.api.Assertions.*;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

public class SecondChallengeTestSuite {

    @Test
    void testSecondChallenge(){
        //given
        NumberChecker numberChecker = new NumberChecker();

        //when & then
        assertDoesNotThrow(() -> numberChecker.checkNumbers(1.5, 2));
    }

    @Test
    void testWhenWrongNumbers(){
        //given
        NumberChecker numberChecker = new NumberChecker();

        //when & then
        assertThrows(ExceptionHandling.class, () -> numberChecker.checkNumbers(3, 1.5));
    }

    @Test
    public void testAllOptions() {
        // given
        NumberChecker numberChecker = new NumberChecker();
        // when & then
        assertAll(
                () -> assertThrows(ExceptionHandling.class, () -> numberChecker.checkNumbers(7,10)),
                () -> assertDoesNotThrow(() ->numberChecker.checkNumbers(1.5,2))
        );
    }
}

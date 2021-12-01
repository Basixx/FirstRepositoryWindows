package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testLog(){
        //given
        logger = Logger.LOG;
        //when
        logger.log("User signed out");
        logger.log("user changed");
        logger.log("User signed in");
        String lastLog = logger.getLastLog();
        //then
        assertEquals("User signed in", lastLog);
    }
}

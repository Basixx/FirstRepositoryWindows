package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd(){
        //Given
        //When
        double result = calculator.add(34.4, 8.2);
        //Then
        assertEquals(result, 42.6, 2);
    }

    @Test
    public void testSubstract(){
        //Given
        //When
        double result = calculator.substract(109.44, 67.95);
        //Then
        assertEquals(result, 41.49,2);
    }

    @Test
    public void testMultiply(){
        //Given
        //When
        double result = calculator.multiply(10.7, 12.8);
        //Then
        assertEquals(result, 136.96);
    }

    @Test
    public void testDivide(){
        //Given
        //When
        double result = calculator.divide(197.28, 13.7);
        //Then
        assertEquals(result, 14.4, 2);
    }
}

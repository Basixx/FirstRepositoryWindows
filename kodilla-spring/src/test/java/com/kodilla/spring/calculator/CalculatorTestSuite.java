package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd(){
        //Given
        //When
        calculator.add(34.4, 8.2);
        //Then
        //do nothing
    }

    @Test
    public void testSubstract(){
        //Given
        //When
        calculator.substract(109.44, 67.95);
        //Then
        //do nothing
    }

    @Test
    public void testMultiply(){
        //Given
        //When
        calculator.multiply(10.73, 12.86);
        //Then
        //do nothing
    }

    @Test
    public void testDivide(){
        //Given
        //When
        calculator.divide(375.58, 12.94);
        //Then
        //do nothing
    }
}

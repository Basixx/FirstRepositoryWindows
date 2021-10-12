package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
    void getAverage(){
        //given
        int[] numbers = new int[] {5, 76, 34, 87, 23,53,2,4,90,23};

        double sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        double avrg = sum / numbers.length;
        //when
        double average = ArrayOperations.getAverage(numbers);

        //then
        Assertions.assertEquals(average, avrg);
    }
}

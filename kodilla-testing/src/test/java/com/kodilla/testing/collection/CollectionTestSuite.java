package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }
    @DisplayName("Empty list check")
    @Test
    void testOddNumbersExterminatorEmptyList(){
                //Given
        List<Integer> emptyList = new ArrayList<>();
        OddNumbersExterminator emptyListToTest = new OddNumbersExterminator();
                //When
        List<Integer> evenEmptyList = emptyListToTest.createList(emptyList);
                //Then
        Assertions.assertTrue(evenEmptyList.isEmpty());

    }
    @DisplayName("Normal list check")
    @Test
    void testOddNumbersExterminatorNormalList(){
                //Given
        List<Integer> normalList = new ArrayList<>();
        normalList.add(5);
        normalList.add(3);
        normalList.add(37);
        normalList.add(84);
        normalList.add(53);
        normalList.add(8);
        normalList.add(8);
        normalList.add(4);
        normalList.add(99);

        List<Integer> normalListReference = new ArrayList<>();
        normalListReference.add(84);
        normalListReference.add(8);
        normalListReference.add(8);
        normalListReference.add(4);

        OddNumbersExterminator normalListToTest = new OddNumbersExterminator();
                //When
        List<Integer> oddNormalList = normalListToTest.createList(normalList);
                //Then
        Assertions.assertEquals(normalListReference, oddNormalList);
    }

    @DisplayName("Normal list check using Array.asList()")
    @Test
    void testOddNumbersExterminatorNormalListWithArray(){
                //Given
        Integer[] allNumbers = new Integer[] {5, 2, 6, 12, 7, 35, 93, 0, 13};

        List<Integer> normalList = Arrays.asList(allNumbers);

        Integer[] evenNumbers = new Integer[] {2,6,12,0};
        List<Integer> normalListReference = Arrays.asList(evenNumbers);


        OddNumbersExterminator normalListToTest = new OddNumbersExterminator();
                //When
        List<Integer> evenNormalList = normalListToTest.createList(normalList);
                //Then
        Assertions.assertEquals(normalListReference, evenNormalList);
    }
}

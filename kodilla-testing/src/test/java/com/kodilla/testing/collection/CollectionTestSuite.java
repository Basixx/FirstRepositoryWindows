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
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> emptyListReference = new ArrayList<>();
        OddNumbersExterminator evenListE = new OddNumbersExterminator();
        List<Integer> evenEmptyList = evenListE.createList(emptyList);
        Assertions.assertEquals(emptyListReference, evenEmptyList);

    }
    @DisplayName("Normal list check")
    @Test
    void testOddNumbersExterminatorNormalList(){
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

        OddNumbersExterminator evenListN = new OddNumbersExterminator();
        List<Integer> oddNormalList = evenListN.createList(normalList);

        Assertions.assertEquals(normalListReference, oddNormalList);
    }

    @DisplayName("Normal list check using Array.asList()")
    @Test
    void testOddNumbersExterminatorNormalListWithArray(){

        Integer[] allNumbers = new Integer[] {5, 2, 6, 12, 7, 35, 93, 0, 13};

        List<Integer> normalList = Arrays.asList(allNumbers);

        Integer[] evenNumbers = new Integer[] {2,6,12,0};
        List<Integer> normalListReference = Arrays.asList(evenNumbers);


        OddNumbersExterminator evenListN = new OddNumbersExterminator();
        List<Integer> evenNormalList = evenListN.createList(normalList);

        Assertions.assertEquals(normalListReference, evenNormalList);
    }
}

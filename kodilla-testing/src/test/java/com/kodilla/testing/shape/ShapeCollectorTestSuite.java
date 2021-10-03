package com.kodilla.testing.shape;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName ("czy dodaje figurę")
    @Test

    void testAddFigure(){
        //given
        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(82);
        Triangle triangle = new Triangle(83);
        Square square = new Square(64);
       ShapeCollector testedListToAdd = new ShapeCollector(new ArrayList<>(Arrays.asList(circle1, triangle, square)));

       //when
        testedListToAdd.addFigure(circle2);

        //then
        Assertions.assertEquals(testedListToAdd.getShapesList().size(), 4);
    }

    @DisplayName("czy usuwa figurę")
    @Test

    void testRemoveFigure(){
        //given
        Circle circle = new Circle(14);
        Triangle triangle = new Triangle(17);
        Square square1 = new Square(25);
        Square square2 = new Square(81);
        ShapeCollector testedListToRemove = new ShapeCollector(new ArrayList<>(Arrays.asList(circle, triangle, square1, square2)));

        //when
        testedListToRemove.removeFigure(circle);

        //then
        Assertions.assertEquals(testedListToRemove.getShapesList().size(), 3);
    }

    @DisplayName("czy pobiera figurę")
    @Test

    void testGetFigure(){
        //given
        Circle circle1 = new Circle(7);
        Circle circle2 = new Circle(3);
        Triangle triangle1 = new Triangle(23);
        Triangle triangle2 = new Triangle(4);
        Square square1 = new Square(16);
        Square square2 = new Square(64);
        ShapeCollector testedListToGet = new ShapeCollector(new ArrayList<>(Arrays.asList(circle2, square1, triangle1, triangle2, circle1, square2)));

        //when
        Shape figure1 = testedListToGet.getFigure(4);
        Shape figure2 = testedListToGet.getFigure(-1);
        Shape figure3 = testedListToGet.getFigure(8);

        //then
        Assertions.assertEquals(figure1, circle1);
        Assertions.assertNull(figure2);
        Assertions.assertNull(figure3);

    }

    @DisplayName("czy pokazuje figury")
    @Test

    void testShowFigures(){
        //given
        Circle circle1 = new Circle(7);
        Circle circle2 = new Circle(3);
        Triangle triangle1 = new Triangle(23);
        Triangle triangle2 = new Triangle(4);
        Square square1 = new Square(16);
        Square square2 = new Square(64);
        ShapeCollector testedListToShow = new ShapeCollector(new ArrayList<>(Arrays.asList(circle2, square1, triangle1, triangle2, circle1, square2)));

        //when
        ArrayList<Shape> shapesCollection = testedListToShow.showFigures();

        //then
        Assertions.assertEquals(testedListToShow.getShapesList(), shapesCollection);

    }
}

package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapesList;

    public ShapeCollector(List<Shape> shapesList) {

        this.shapesList = shapesList;
    }

    void addFigure(Shape shape){

    }
    void removeFigure(Shape shape){

    }
    Shape getFigure(int n){
        Square shapeX = new Square(15);
        return shapeX;
    }
    void showFigures(){

    }

    public List<Shape> getShapesList(){
        return shapesList;
    }
}


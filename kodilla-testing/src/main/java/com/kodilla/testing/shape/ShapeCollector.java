package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapesList;

    public ShapeCollector(List<Shape> shapesList) {

        this.shapesList = shapesList;
    }

    void addFigure(Shape shape){
        shapesList.add(shape);
    }
    void removeFigure(Shape shape){
        shapesList.remove(shape);
    }
    Shape getFigure(int n){
        if (n < shapesList.size() && n >=0){
            return shapesList.get(n);
        }
        else{
            return null;
        }
    }
    ArrayList<Shape> showFigures(){
        ArrayList<Shape> showedFiguresList = new ArrayList<>();
        for (Shape figure : shapesList){
            System.out.println(figure);
            showedFiguresList.add(figure);
        }
        return showedFiguresList;
    }

    public List<Shape> getShapesList(){
        return shapesList;
    }
}


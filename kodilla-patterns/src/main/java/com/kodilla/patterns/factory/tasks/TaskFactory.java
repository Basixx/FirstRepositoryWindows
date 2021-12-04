package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String shapeClass){
        switch(shapeClass){
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping", "Milk", 10);
            case PAINTING_TASK:
                return new PaintingTask("Painting", "Blue", "Sky");
            case DRIVING_TASK:
                return new DrivingTask("Driving", "Home", "Bus");
            default:
                return null;
        }
    }
}

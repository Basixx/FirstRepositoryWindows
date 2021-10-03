package com.kodilla.testing.shape;

public class Circle implements Shape{
    private String shapeName;
    private double field;

    public Circle(double field) {
        this.shapeName = "Circle";
        this.field = field;
    }

    public String getShapeName(){

        return this.shapeName;
    }
    public double getField(){

        return this.field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.field, field) != 0) return false;
        return shapeName != null ? shapeName.equals(circle.shapeName) : circle.shapeName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeName != null ? shapeName.hashCode() : 0;
        temp = Double.doubleToLongBits(field);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "shapeName='" + shapeName + '\'' +
                ", field=" + field +
                '}';
    }
}

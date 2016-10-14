package ru.academit.Semianinov.Geometry.Shape;

public class Square {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    double getHeight() {
        return sideLength;
    }

    double getArea() {
        return Math.pow(sideLength,2);
    }

    double getPerimeter() {
        return sideLength*4;
    }

}

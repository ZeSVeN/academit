package ru.academit.Semianinov.Geometry.Shape;

public class Rectangle {

    private double firstSide;
    private double secondSide;

    public Rectangle(double firstSide, double secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    double getWidth() {
        return Math.min(firstSide,secondSide);
    }

    double getHeight() {
        return Math.max(firstSide,secondSide);
    }

    double getArea() {
        return firstSide*secondSide;
    }

    double getPerimeter() {
        return firstSide*2+secondSide*2;
    }
}

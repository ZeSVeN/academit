package ru.academit.Semianinov.Geometry.Shape;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double firstSide, double secondSide) {
        this.width = firstSide;
        this.height = secondSide;
    }

    public double getWidth() {
        return Math.min(width, height);
    }

    public double getHeight() {
        return Math.max(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width * 2 + height * 2;
    }
}

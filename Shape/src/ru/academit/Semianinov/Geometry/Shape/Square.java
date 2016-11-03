package ru.academit.Semianinov.Geometry.Shape;

public class Square implements Shape {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    public double getPerimeter() {
        return sideLength * 4;
    }

    public int compareTo(Shape o) {
        if (this.getArea() < o.getArea()) {
            return -1;
        } else if (this.getArea() > o.getArea()) {
            return 1;
        } else return 0;
    }
}

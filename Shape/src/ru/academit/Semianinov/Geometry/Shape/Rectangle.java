package ru.academit.Semianinov.Geometry.Shape;

public class Rectangle implements Shape {

    private double width;
    private double height;

    public Rectangle(double firstSide, double secondSide) {
        this.width = firstSide;
        this.height = secondSide;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width * 2 + height * 2;
    }

    public int compareTo(Shape o) {
        if (this.getArea() < o.getArea()) {
            return -1;
        } else if (this.getArea() > o.getArea()) {
            return 1;
        } else return 0;
    }
}

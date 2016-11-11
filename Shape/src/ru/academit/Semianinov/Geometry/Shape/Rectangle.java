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

    @Override
    public String toString() {
        return String.format("Rectangle { width = %.1f, height = %.1f }", width, height);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || o.getClass() != this.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        return rectangle.width == width && rectangle.height == height;
    }

    @Override
    public int hashCode() {
        return (int) (23 * (width + height));
    }
}


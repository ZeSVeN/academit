package ru.academit.Semianinov.Geometry.Shape;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle { radius = %.1f }",radius);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || o.getClass() != this.getClass()) return false;

        Circle circle = (Circle) o;

        return circle.radius == radius;
    }

    @Override
    public int hashCode() {
        return (int) (23*radius);
    }
}

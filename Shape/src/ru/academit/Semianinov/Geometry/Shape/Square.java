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

    @Override
    public String toString() {
        return String.format("Square { sideLength = %.1f }", sideLength);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || o.getClass() != this.getClass()) return false;

        Square square = (Square) o;

        return square.sideLength == sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        return  hash * prime + (int) sideLength;
    }
}

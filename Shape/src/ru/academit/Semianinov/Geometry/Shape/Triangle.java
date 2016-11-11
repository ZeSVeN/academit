package ru.academit.Semianinov.Geometry.Shape;

public class Triangle implements Shape {

    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {

        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;

    }

    public double getWidth() {
        return getMaxX() - getMinX();
    }

    public double getHeight() {
        return getMaxY() - getMinY();
    }

    public double getArea() {

        double halfPerimeter = getPerimeter() / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - getSideLength(x1, y1, x2, y2)) * (halfPerimeter - getSideLength(x2, y2, x3, y3)) * (halfPerimeter - getSideLength(x1, y1, x3, y3)));
    }

    public double getPerimeter() {

        double sideOneLength = getSideLength(x1, y1, x2, y2);
        double sideTwoLength = getSideLength(x2, y2, x3, y3);
        double sideThreeLength = getSideLength(x1, y3, x3, y3);

        return sideOneLength + sideTwoLength + sideThreeLength;
    }

    private double getMaxX() {
        return Math.max(x1, Math.max(x2, x3));
    }

    private double getMinX() {
        return Math.min(x1, Math.min(x2, x3));
    }

    private double getMaxY() {
        return Math.max(y1, Math.max(y2, y3));
    }

    private double getMinY() {
        return Math.min(y1, Math.min(y2, y3));
    }

    private static double getSideLength(double xSecond, double ySecond, double xFirst, double yFirst) {
        return Math.sqrt(Math.pow((xSecond - xFirst), 2) + Math.pow((ySecond - yFirst), 2));
    }

    @Override
    public String toString() {
        return String.format("Triangle { x1 = %.1f, y1 = %.1f, x2 = %.1f, y2 = %.1f, x3 = %.1f, y3= %.1f }", x1, y1, x2, y2, x3, y3);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || o.getClass() != this.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return x1 == triangle.x1 &&
                x2 == triangle.x2 &&
                x3 == triangle.x3 &&
                y1 == triangle.y1 &&
                y2 == triangle.y2 &&
                y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        hash = hash * prime + (int) x1;
        hash = hash * prime + (int) y1;
        hash = hash * prime + (int) x2;
        hash = hash * prime + (int) y2;
        hash = hash * prime + (int) x3;
        hash = hash * prime + (int) y3;
        return hash;
    }
}


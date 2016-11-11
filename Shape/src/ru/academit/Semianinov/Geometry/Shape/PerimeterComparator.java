package ru.academit.Semianinov.Geometry.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return shape1.getPerimeter() < shape2.getPerimeter() ? 1 : shape1.getPerimeter() > shape2.getPerimeter() ? -1 : 0;
    }
}

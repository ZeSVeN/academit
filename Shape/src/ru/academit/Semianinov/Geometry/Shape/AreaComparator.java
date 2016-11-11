package ru.academit.Semianinov.Geometry.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return shape1.getArea() > shape2.getArea() ? 1 : shape1.getArea() < shape2.getArea() ? -1 : 0;
    }
}

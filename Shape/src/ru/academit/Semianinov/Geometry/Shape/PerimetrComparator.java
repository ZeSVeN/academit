package ru.academit.Semianinov.Geometry.Shape;

import java.util.Comparator;

/**
 * Created by ZeSVeN on 11.11.2016.
 */
public class PerimetrComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return shape1.getPerimeter() > shape2.getPerimetr() ? 1 : shape1.getPerimetr() < shape2.getPerimetr() ? -1 : 0;
    }
}

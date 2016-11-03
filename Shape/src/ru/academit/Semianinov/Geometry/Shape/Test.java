package ru.academit.Semianinov.Geometry.Shape;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {

        Shape square1 = new Square(4);

        Shape triangle = new Triangle(1, 2, 6, 5, 9, 0);

        Shape rectangle = new Rectangle(5, 6);

        Shape circle = new Circle(10);

        System.out.println(square1.getArea());
        System.out.println(triangle.getArea());
        System.out.println(rectangle.getArea());
        System.out.println(circle.getArea());
    }


}
package ru.academit.Semianinov.Geometry.Shape;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Shape square1 = new Square(4);
        Shape triangle = new Triangle(1, 2, 6, 5, 9, 0);
        Shape rectangle = new Rectangle(5, 6);
        Shape circle = new Circle(2);
        Shape triangle1 = new Triangle(6, 4, 6, 1, 5, 6);
        Shape circle1 = new Circle(20);

        Shape[] shapes = {square1, triangle, rectangle, circle, triangle1, circle1};

        List<Shape> shapesList = new ArrayList<>(Arrays.asList(shapes));

        Shape max = Collections.max(shapesList, new AreaComparator());

        System.out.println(max.toString());

        Arrays.sort(shapes, new PerimeterComparator());

        System.out.println(shapes[1].toString());
    }
}
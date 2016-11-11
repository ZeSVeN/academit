package ru.academit.Semianinov.Geometry.Shape;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Shape square1 = new Square(4);
        Shape triangle = new Triangle(1, 2, 6, 5, 9, 0);
        Shape rectangle = new Rectangle(5, 6);
        Shape circle = new Circle(10);
        Shape triangle1 = new Triangle(6, 4, 6, 1, 5, 6);
        Shape circle1 = new Circle(20);

        Shape[] test = {square1, triangle, rectangle, circle, triangle1, circle1};

        List<Shape> shapes = new ArrayList<>(Arrays.asList(test));

        Shape max = Collections.max(shapes, new AreaComparator());

        System.out.println(max.toString());

        Collections.sort(shapes, new PerimeterComparator());

        Shape secondArea = shapes.get(1);

        System.out.println(secondArea.toString());
    }
}
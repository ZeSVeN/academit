package ru.academit.semianinov.vector;


public class Main {
    public static void main(String[] args) {

        double[] array = {1, 6, 5, 3, 6, 7, 8};

        Vector vector = new Vector(3);

        System.out.println(vector.getSize());

        Vector vector1 = new Vector(array);

        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());

        Vector vector3 = new Vector(10, array);
        System.out.println(vector3.toString());
    }
}

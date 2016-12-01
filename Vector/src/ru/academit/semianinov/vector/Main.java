package ru.academit.semianinov.vector;


public class Main {
    public static void main(String[] args) {

        double[] array = {1, 2, 3, 4};
        Vector vector = new Vector(10,array);
        System.out.println(vector.toString());
    }
}

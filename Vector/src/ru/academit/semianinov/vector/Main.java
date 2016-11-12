package ru.academit.semianinov.vector;


public class Main {
    public static void main(String[] args) {

        Vector vector = new Vector(3);

        System.out.println(vector.getSize());

        double[] array = {1, 6, 5, 3, 6, 7, 8};
        Vector vector1 = new Vector(array);

        Vector vector2 = new Vector(vector1);

        //vector2.setValue(0, 1.00001);
        System.out.println(vector1.equals(vector2));
        double[] array1 = {1, 6, 8, 2, 4, 6, 8, 2, 7};
        Vector vector3 = new Vector(array1);
        vector3.multiplication(2);

        vector1.add(vector2);

        vector1.reverse();

        vector1.remove(vector2);

        vector1.setValue(0, 0);

        vector3.add(vector1);

        System.out.println(Vector.sum(vector3, vector1));
        System.out.println(Vector.subtraction(vector1, vector1));
        System.out.println(Vector.scalarProduct(vector1, vector3));
    }
}

package ru.academit.semianinov.matrix;

import ru.academit.semianinov.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        double[][] array = {{1, 2, 3, 4}, {2, 3, 4}, {6, 7, 4, 6},{1}};
        double[] array1 = {1, 2, 3, 5, 6};
        double[] array2 = {1, 2, 3, 4, 5, 6, 7};
        Vector[] vectors = new Vector[4];
        vectors[0] = new Vector(5);
        vectors[1] = new Vector(array1);
        vectors[2] = new Vector(array1);
        vectors[3] = new Vector(array2);

        Matrix matrix = new Matrix(array);

        Matrix matrix1 = new Matrix(vectors);

        System.out.println(matrix.toString());
        //System.out.println(matrix1.toString());
        //System.out.println(vectors[0].toString());
    }
}

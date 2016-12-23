package ru.academit.semianinov.matrix;

import ru.academit.semianinov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] array = {{1, 2, 3, 4, 5, 6}, {2, 3, 4, 8, 9, 10}, {6, 7, 4, 6, 1, 7,}, {1, 1, 1, 1, 1}, {1, 6, 8, 5, 0, 1}, {7, 1, 7, 4, 3}};
        double[][] newArray = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1, 1}};
        double[] array1 = {1, 2, 3, 5, 6};
        double[] array2 = {1, 2, 3, 4, 5, 6, 7};
        double[] array3 = {2, 2, 2, 2};
        double[] array4 = {3, 2, 1, 0, 1};

        Vector vector = new Vector(array3);
        Vector[] vectors = new Vector[3];
        vectors[0] = new Vector(5);
        vectors[1] = new Vector(array1);
        vectors[2] = new Vector(array1);
       // vectors[3] = new Vector(array2);
        //vectors[4] = new Vector(array4);

        Matrix matrix = new Matrix(newArray);

        Matrix matrix1 = new Matrix(vectors);

        System.out.println(matrix);
        System.out.println(matrix1);
        matrix.sub(matrix1);
        System.out.println(matrix);
    }
}

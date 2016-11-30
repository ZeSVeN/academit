package ru.academit.semianinov.vector;

import java.util.Arrays;

public class Vector {

    private double[] array;

    public Vector(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException(Integer.toString(size));
        }

        this.array = new double[size];
    }

    public Vector(Vector vector) {

        this(vector.array);
    }

    public Vector(double[] array) {

        this(array.length, array);
    }

    public Vector(int size, double[] array) {

        this(size);

        System.arraycopy(array, 0, this.array, 0, size);
    }

    public int getSize() {
        return array.length;
    }

    public String toString() {

        StringBuilder string = new StringBuilder();

        string.append("{ ");

        for (double e : this.array) {
            string.append(e)
                    .append(", ");
        }

        string.delete(string.length() - 2, string.length() - 1);
        string.append("}");

        return string.toString();
    }

    public void sum(Vector vector) {
        if (this.getSize() < vector.getSize()) {

            double[] tmp = new double[vector.getSize()];
            System.arraycopy(this.array, 0, tmp, 0, this.array.length);

            this.array = tmp;
        }

        for (int i = 0; i < vector.getSize(); ++i) {
            this.array[i] = this.array[i] + vector.array[i];
        }
    }

    public void sub(Vector vector) {
        if (this.getSize() < vector.getSize()) {

            double[] tmp = new double[vector.getSize()];
            System.arraycopy(this.array, 0, tmp, 0, this.array.length);

            this.array = tmp;
        }

        for (int i = 0; i < vector.getSize(); ++i) {
            this.array[i] = this.array[i] - vector.array[i];
        }
    }

    public void multiplication(double number) {
        for (int i = 0; i < this.array.length; ++i) {
            array[i] = array[i] * number;
        }
    }

    public void reverse() {
        this.multiplication(-1);
    }

    public double getLength() {

        double sum = 0;

        for (double e : this.array) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public void setValue(int index, double value) {
        checkIndex(index);
        array[index] = value;
    }

    private void checkIndex(int index) {
        if (index < 0 || array.length <= index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует");
        }
    }


    public double getValue(int index) {
        checkIndex(index);
        return array[index];
    }

    public static Vector sum(Vector vector1, Vector vector2) {

        int vectorSize = Math.max(vector1.getSize(), vector2.getSize());

        Vector vector = new Vector(vectorSize);

        vector.sum(vector1);
        vector.sum(vector2);

        return vector;
    }

    public static Vector subtraction(Vector vector1, Vector vector2) {

        int vectorSize = Math.max(vector1.getSize(), vector2.getSize());

        Vector vector = new Vector(vectorSize);

        vector.sum(vector1);
        vector.sub(vector2);

        return vector;
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {

        double result = 0;
        int minVectorSize = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < minVectorSize; ++i) {
            result += vector1.getValue(i) * vector2.getValue(i);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (this.array.length == vector.getSize()) {

            double accuracy = 0.0001;

            for (int i = 0; i < array.length; ++i) {
                if (Math.abs(this.array[i] - vector.array[i]) > accuracy) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        return hash * prime + Arrays.hashCode(array);
    }
}
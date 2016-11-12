package ru.academit.semianinov.vector;

import java.util.Arrays;

class Vector {

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

        for (int i = 0; i < this.array.length; ++i) {
            if (i >= (array.length)) {
                continue;
            }
            this.array[i] = array[i];
        }
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

    public void add(Vector vector) {

        int newSize = this.array.length + vector.getSize();
        double[] newArray = new double[newSize];

        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        System.arraycopy(vector.array, 0, newArray, this.array.length, vector.getSize());

        this.array = newArray;
    }

    public void remove(Vector vector) {

        int newSize = this.array.length - vector.getSize();
        double[] newArray = new double[newSize];

        System.arraycopy(this.array, 0, newArray, 0, newSize);
        this.array = newArray;
    }

    public void multiplication(double number) {
        for (int i = 0; i < this.array.length; ++i) {
            array[i] = array[i] * number;
        }
    }

    public void revers() {
        for (int i = 0; i < this.array.length; ++i) {
            array[i] = array[i] * (-1);
        }
    }

    public void setValue(int index, double value) {
        array[index] = value;
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
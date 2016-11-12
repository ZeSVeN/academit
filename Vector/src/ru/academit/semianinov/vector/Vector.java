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

        for (int i = 0; i < array.length; ++i) {
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
        if (this.getSize() < vector.getSize()) {

            Vector tmp = new Vector(vector.getSize(), this.array);

            this.array = tmp.array;
        }

        for (int i = 0; i < vector.getSize(); ++i) {
            this.array[i] = this.array[i] + vector.array[i];
        }
    }

    public void remove(Vector vector) {
        if (this.getSize() < vector.getSize()) {

            Vector tmp = new Vector(vector.getSize(), this.array);

            this.array = tmp.array;
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

    public void setValue(int index, double value) {
        this.getValue(index);
        array[index] = value;
    }

    public double getValue(int index) {
        if (array.length <= index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует");
        }
        return array[index];
    }

    public static Vector sum(Vector vector1, Vector vector2) {

        if (vector1.getSize() < vector2.getSize()) {
            vector1 = new Vector(vector2.getSize(), vector1.array);
        } else if (vector1.getSize() > vector2.getSize()) {
            vector2 = new Vector(vector1.getSize(), vector2.array);
        }

        Vector vector = new Vector(vector1.getSize());

        for (int i = 0; i < vector.getSize(); ++i) {
            vector.array[i] = vector1.array[i] + vector2.array[i];
        }
        return new Vector(vector);
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
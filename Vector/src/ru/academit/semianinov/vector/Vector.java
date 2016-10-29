package ru.academit.semianinov.vector;

import java.util.ArrayList;

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
        string.deleteCharAt(string.length() - 1);
        string.append(" }");

        return string.toString();
    }
}

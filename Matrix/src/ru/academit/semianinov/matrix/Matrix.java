package ru.academit.semianinov.matrix;

import ru.academit.semianinov.vector.Vector;

public class Matrix {

    private Vector[] vector;

    private void validation(int size) {
        //TODO Сделать отдельные валидации для отрицательного значения и для выхода за границы массива
        if (size < 0 || vector.length < size || vector[0].getLength() < size) {
            throw new IndexOutOfBoundsException("Недопустимый размер матрицы");
        }
    }

    public Matrix(int n, int m) {

        validation(n);
        validation(m);

        for (int i = 0; i <= m; ++i) {
            this.vector[i] = new Vector(n);
        }
    }

    public Matrix(double[][] array) {
        this(array.length, array[0].length);
    }

    public Matrix(Matrix matrix) {

        this(matrix.vector.length, matrix.vector[0].getSize());

        for (int i = 0; i < vector[0].getSize(); ++i) {
            System.arraycopy(matrix.vector, 0, this.vector, 0, matrix.vector.length);
        }
    }

    public Matrix(Vector[] vector) {
        this(new Matrix(vector));
    }

    public int getSize() {
        return vector.length * vector[0].getSize();
    }

    public void setLine(int index, Vector vector) {

        validation(index);

        this.vector[index] = vector;
    }

    public String getLine(int index) {

        validation(index);

        return vector[index].toString();
    }

    public void transpose() {

        for (int i = 0; i < vector[0].getSize(); ++i) {
            for (int j = i; j < vector.length; ++j) {

                Vector tmpVector = new Vector(vector.length);
                double tmp = this.vector[j].getValue(i);
                tmpVector.setValue(j, tmp);
            }
        }
    }
}

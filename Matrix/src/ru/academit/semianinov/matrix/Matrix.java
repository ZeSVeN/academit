package ru.academit.semianinov.matrix;

import ru.academit.semianinov.vector.Vector;
import ru.academit.semianinov.vector.LengthComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Matrix {

    private Vector[] row;

    private void validateSize(int size) {

        if (size <= 0) {
            throw new IndexOutOfBoundsException("Недопустимый размер матрицы");
        }
    }

    private void validateIndex(int index) {

        if (row.length < index || row[0].getLength() < index) {
            throw new IndexOutOfBoundsException("Выход за границы массива");
        }
    }

    public Matrix(int row, int column) {

        validateSize(row);
        validateSize(column);

        this.row = new Vector[row];

        for (int i = 0; i < row; ++i) {
            this.row[i] = new Vector(column);
        }
    }

    public Matrix(double[][] array) {

        int maxLength = 0;

        for (double[] e : array) {
            if (maxLength < e.length) {
                maxLength = e.length;
            }
        }

        this.row = new Vector[array.length];

        for (int i = 0; i < array.length; ++i) {
            this.row[i] = new Vector(maxLength);
            for (int j = 0; j < array[i].length; ++j) {
                this.row[i].setValue(j, array[i][j]);
            }
        }
    }

    public Matrix(Matrix matrix) {

        this(matrix.row.length, matrix.row[0].getSize());

        System.arraycopy(matrix.row, 0, this.row, 0, matrix.row.length);

    }

    public Matrix(Vector[] vector) {

        List<Vector> vectorList = new ArrayList<>(Arrays.asList(vector));
        Vector max = Collections.max(vectorList, new LengthComparator());

        int maxLength = max.getSize();

        this.row = new Vector[vector.length];

        for (int i = 0; i < vector.length; ++i) {
            row[i] = new Vector(maxLength);
            row[i].sum(vector[i]);
        }
    }

    public int getSize() {
        return row.length * row[0].getSize();
    }

    public void setLine(int index, Vector vector) {

        validateIndex(index);

        for (int i = 0; i < vector.getLength(); ++i) {
            row[index].setValue(i, vector.getValue(i));
        }
    }

    public Vector getLine(int index) {

        validateSize(index);

        return row[index];
    }

    public void transpose() {

        //Matrix tmpMatrix = new Matrix(this);
        double[][] tmpArray = new double[row[0].getSize()][row.length];

        for (int i = 0; i < row.length; ++i) {

            for (int j = i; j < tmpArray[0].length; ++j) {
                tmpArray[i][j] = this.row[j].getValue(i);
            }

            //Vector tmpVector = new Vector(array);

            //this.setLine(i, tmpVector);
        }


        Matrix tmpMatrix = new Matrix(tmpArray);

        for (int i = 0; i < row.length; ++i) {
            setLine(i, tmpMatrix.getLine(i));
        }
    }

    public String toString() {

        StringBuilder string = new StringBuilder();

        string.append("{");

        for (Vector e : this.row) {
            string.append(e.toString())
                    .append(",");
        }

        string.delete(string.length() - 1, string.length());
        string.append("}");
        return string.toString();
    }
}

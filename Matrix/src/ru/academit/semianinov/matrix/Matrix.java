package ru.academit.semianinov.matrix;

import ru.academit.semianinov.vector.Vector;
import ru.academit.semianinov.vector.LengthComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Matrix {

    private Vector[] rows;

    private boolean isInsideRow(int size) {
        return rows[0].getLength() >= size;
    }

    private boolean isInsideColumn(int size) {
        return rows.length >= size;
    }

    private void validateSize(int size) {
        if (size <= 0) {
            throw new IndexOutOfBoundsException("Недопустимый размер матрицы");
        }
    }

    private void validateColumnIndex(int index) {
        if (index < 0 && index <= rows.length) {
            throw new IndexOutOfBoundsException("Выход за границу столбца");
        }
    }

    private void validateRowIndex(int index) {
        if (index < 0 && index <= rows[0].getSize()) {
            throw new IndexOutOfBoundsException("Выход за границу ряда");
        }
    }

    public Matrix(int row, int column) {
        validateSize(row);
        validateSize(column);

        this.rows = new Vector[row];

        for (int i = 0; i < row; ++i) {
            this.rows[i] = new Vector(column);
        }
    }

    public Matrix(double[][] array) {
        int maxLength = 0;

        for (double[] e : array) {
            if (maxLength < e.length) {
                maxLength = e.length;
            }
        }

        this.rows = new Vector[array.length];

        for (int i = 0; i < array.length; ++i) {

            this.rows[i] = new Vector(maxLength, array[i]);

        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.rows.length, matrix.rows[0].getSize());

        for (int i = 0; i < rows.length; ++i) {
            this.rows[i] = matrix.rows[i];
        }

    }

    public Matrix(Vector[] vector) {
        List<Vector> vectorList = new ArrayList<>(Arrays.asList(vector));
        Vector max = Collections.max(vectorList, new LengthComparator());

        int maxLength = max.getSize();

        this.rows = new Vector[vector.length];

        for (int i = 0; i < vector.length; ++i) {
            rows[i] = new Vector(maxLength);
            rows[i].sum(vector[i]);
        }
    }

    public int getSize() {
        return rows.length * rows[0].getSize();
    }

    public void setRow(int index, Vector vector) {
        validateColumnIndex(index);

        if (isInsideRow(vector.getSize())) {
            for (int i = 0; i < rows.length; ++i) {
                Vector tmp = new Vector(rows[i]);

                this.rows[i] = new Vector(vector.getSize());
                this.rows[i].sum(tmp);
            }
        }

        for (int i = 0; i < vector.getLength(); ++i) {
            rows[index].setValue(i, vector.getValue(i));
        }
    }

    public Vector getRow(int index) {
        validateColumnIndex(index);

        return new Vector(rows[index]);
    }

    public Vector getColumn(int index) {
        validateRowIndex(index);

        Vector column = new Vector(rows.length);
        for (int i = 0; i < rows.length; ++i) {
            column.setValue(i, rows[i].getValue(index));
        }
        return column;
    }

    public void transpose() {
        Vector[] tmpVector = new Vector[rows[0].getSize()];

        for (int i = 0; i < rows.length; ++i) {
            tmpVector[i] = new Vector(getColumn(i));
        }

        for (int i = 0; i < rows.length; ++i) {
            rows[i] = new Vector(tmpVector[i]);
        }
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("{");

        for (Vector e : this.rows) {
            string.append(e.toString())
                    .append(",");
        }

        string.delete(string.length() - 1, string.length());
        string.append("}");
        return string.toString();
    }

    public void multiplication(double number) {
        for (int i = 0; i < rows.length; ++i) {
            rows[i].multiplication(number);
        }
    }

    public double determinant() {
        return calcDeterminant(this);
    }

    private double calcDeterminant(Matrix matrix) {
        double calcResult = 0.0;

        if (matrix.rows.length == 2) {
            calcResult = matrix.rows[0].getValue(0) * matrix.rows[1].getValue(1) - matrix.rows[1].getValue(0) * matrix.rows[0].getValue(1);
        } else {
            int coefficient;

            for (int i = 0; i < matrix.rows.length; i++) {
                if (i % 2 == 1) {
                    coefficient = -1;
                } else {
                    coefficient = 1;
                }
                calcResult += coefficient * matrix.rows[0].getValue(i) * calcDeterminant(getMinor(matrix, 0, i));
            }
        }
        return calcResult;
    }


    private Matrix getMinor(Matrix matrix, int row, int column) {
        int minorLength = matrix.rows.length - 1;
        double[][] minor = new double[minorLength][minorLength];

        int skipRow = 0;

        for (int i = 0; i <= minorLength; i++) {
            int skipColumn = 0;

            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    skipRow = 1;
                } else {
                    if (j == column) {
                        skipColumn = 1;
                    } else {
                        minor[i - skipRow][j - skipColumn] = matrix.rows[i].getValue(j);
                    }
                }
            }
        }
        return new Matrix(minor);
    }

    public Vector multiplicationOnVector(Vector vector) {
        try {
            if (vector.getSize() != rows[0].getSize()) {
                throw new Exception("Длинна вектора не совпадает с колличеством столбцов в матрице");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Vector resultVector = new Vector(vector.getSize());

        for (int i = 0; i < rows.length; ++i) {
            double result = 0;

            for (int j = 0; j < rows[i].getSize(); ++j) {
                result += rows[i].getValue(j) * vector.getValue(j);
            }

            resultVector.setValue(i, result);
        }
        return resultVector;
    }

    private void resizeMatrix(Matrix matrix) {
        Matrix tmpMatrix = new Matrix(this);
        this.rows = new Vector[matrix.rows.length];

        for (int i = 0; i < rows.length; ++i) {
            try {
                rows[i] = new Vector(tmpMatrix.rows[i]);
            } catch (IndexOutOfBoundsException e) {
                rows[i] = new Vector(tmpMatrix.rows[0].getSize());
            }
        }
    }

    public void sum(Matrix matrix) {
        if (rows.length < matrix.rows.length) {
            resizeMatrix(matrix);
        }
        for (int i = 0; i < rows.length; ++i) {
            try {
                rows[i].sum(matrix.rows[i]);
            } catch (ArrayIndexOutOfBoundsException e) {  //Костыль?
                rows[i].sum(new Vector(matrix.rows[0].getSize()));
            }
        }
    }

    public void sub(Matrix matrix) {
        if (rows.length < matrix.rows.length) {
            resizeMatrix(matrix);
        }
        for (int i = 0; i < rows.length; ++i) {
            try {
                rows[i].sub(matrix.rows[i]);
            } catch (ArrayIndexOutOfBoundsException e) {  //Костыль?
                rows[i].sum(new Vector(matrix.rows[0].getSize()));
            }
        }
    }
}
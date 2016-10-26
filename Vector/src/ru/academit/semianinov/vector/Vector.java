package ru.academit.semianinov.vector;

class Vector {

    private double[] array;
    private int size;

    public Vector(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException(Integer.toString(size));
        }

        this.size = size;
        this.array = new double[size];
        for (int i = 0; i <= this.size - 1; ++i) {
            this.array[i] = 0;
        }
    }

    public Vector(Vector vector) {

        this.size = vector.getSize();
        this.array = new double[size];

        System.arraycopy(vector.array, 0, this.array, 0, vector.getSize());
    }

    public Vector(double[] array) {

        size = array.length;
        this.array = new double[size];

        for (int i = 0; i <= size - 1; ++i) {
            this.array[i] = array[i];
        }
    }

    public Vector(int size, double[] array) {

        this.size = size;
        this.array = new double[size];

        for (int i = 0; i <= this.size - 1; ++i) {
            if (i >= (array.length - 1)) {
                this.array[i] = 0;
                continue;
            }
            this.array[i] = array[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public void toString1() {

        StringBuilder string = new StringBuilder();

        string.append("{ ");
        for (double e : this.array) {
            string.append(e)
                    .append(",");
        }
        string.deleteCharAt(string.length() - 1);
        string.append(" }");

        System.out.println(string.toString());
    }
}

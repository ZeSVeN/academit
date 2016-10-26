package ru.academit.semianinov.range;

class Range {

    private int from;
    private int to;

    public Range(int firstNumber, int secondNumber) {
        boolean isCorrectOrder = firstNumber < secondNumber;
        if (isCorrectOrder) {
            from = firstNumber;
            to = secondNumber;
        } else {
            from = secondNumber;
            to = firstNumber;
        }
    }

    public boolean isInside(int number) {
        return number >= from && number <= to;
    }

    public Range getIntersectionInterval(Range range) {
        if (range.to <= this.from || range.from >= this.to) {
            return null;
        }
        if (isInside(range.from) && isInside(range.to)) {
            return new Range(range.from, range.to);
        }
        if (isInside(range.from)) {
            return new Range(range.from, this.to);
        }
        if (isInside(range.to)) {
            return new Range(this.from, range.to);
        }
        return new Range(this.from, this.to);
    }

    public int[][] union(Range range) {
        if (this.to >= range.from) {
            int[][] array = {{this.from, range.to}, {0, 0}}; // Что делать, когда кусок один?
            return array;
        }
        int[][] array = {{this.from, this.to}, {range.from, range.to}}; // Возвращаем два диапазона.
        return array;
    }


    public int[][] difference(Range range) {
        if (getIntersectionInterval(range) == null) {
            int[][] array = {{this.from, this.to}, {0, 0}};
            return array;
        }
        Range intersection = getIntersectionInterval(range);
        int[][] array = {{this.from, intersection.from}, {intersection.to, this.to}};
        return array;
    }

    public int calcLengthInterval() {
        return to - from;
    }

    private static int getMaxNumber(int firstNumber, int secondNumber) {
        return (firstNumber > secondNumber) ? firstNumber : secondNumber;
    }

    private static int getMinNumber(int firstNumber, int secondNumber) {
        return (firstNumber < secondNumber) ? firstNumber : secondNumber;
    }

    public void print() {
        System.out.printf("(%d %d)%n", from, to);
    }
}

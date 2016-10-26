package ru.academit.semianinov.range;

class Range {

    private double from;
    private double to;

    public Range(double firstNumber, double secondNumber) {

        boolean isCorrectOrder = firstNumber < secondNumber;

        if (isCorrectOrder) {
            from = firstNumber;
            to = secondNumber;
        } else {
            from = secondNumber;
            to = firstNumber;
        }
    }

    public boolean isInside(double number) {
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

    public Range[] union(Range range) {

        if ((getIntersectionInterval(range) == null)) {
            return new Range[]{this, range};
        }
        return new Range[]{new Range(getMinNumber(this.from, range.from), getMaxNumber(this.to, range.to))};
    }


    public Range[] difference(Range range) {

        if (this.getIntersectionInterval(range) == null) {
            return new Range[]{this};
        }

        if (isInside(range.from) && isInside(range.to)) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }

        if (isInside(range.from)) {
            return new Range[]{new Range(this.from, range.from)};
        }

        if (isInside(range.to)) {
            return new Range[]{new Range(range.to, this.to)};
        }

        return new Range[0];
    }

    public double calcLengthInterval() {
        return to - from;
    }

    private static double getMaxNumber(double firstNumber, double secondNumber) {
        return (firstNumber > secondNumber) ? firstNumber : secondNumber;
    }

    private static double getMinNumber(double firstNumber, double secondNumber) {
        return (firstNumber < secondNumber) ? firstNumber : secondNumber;
    }

    public void print() {
        System.out.printf("(%f %f)%n", from, to);
    }
}

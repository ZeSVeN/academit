package ru.academit.Semianinov.Range;

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
        if (isInside(range.from) && !isInside(range.to)) {
            return new Range(range.from, this.to);
        }
        if (!isInside(range.from) && isInside(range.to)) {
            return new Range(this.from, range.to);
        }
        return new Range(this.from, this.to);
    }

    public Range union(Range range) {
        int max = getMaxNumber(range.to, this.to);
        int min = getMinNumber(range.from, this.from);
        return new Range(min, max);
    }

    public Range difference(Range range) {
        if (getIntersectionInterval(range) == null) {
            return new Range(this.from, this.to);
        }
        int differenceEnd = getMaxNumber(this.to, range.to) - getMinNumber(this.to, range.to);
        int differenceBegin = getMaxNumber(this.from, range.from) - getMinNumber(this.from, range.from);
        return new Range(differenceBegin, differenceEnd);
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

package ru.academit.Semianinov.Range;

public class Main {
    public static void main(String[] args) {

        Range range = new Range(1, 100);
        range.print();

        System.out.println("Длинна интервала " + range.calcLengthInterval());
        System.out.println(range.isInside(90));

        Range range1 = new Range(50, 80);
        Range range2 = new Range(30, 60);

        Range range3 = range1.getIntersectionInterval(range2);

        if (range3 == null) {
            System.out.println("null");
        } else {
            range3.print();
        }

        Range range4 = range2.union(range1);
        range4.print();

        Range range5 = range1.difference(range2);
        range5.print();
    }
}

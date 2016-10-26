package ru.academit.semianinov.range;

public class Main {
    public static void main(String[] args) {

        Range range = new Range(1, 100);
        range.print();

        System.out.println("Длинна интервала " + range.calcLengthInterval());
        System.out.println(range.isInside(90));

        Range range1 = new Range(1, 5);
        Range range2 = new Range(4, 6);

        Range range3 = range1.getIntersectionInterval(range2);

        if (range3 == null) {
            System.out.println("null");
        } else {
            range3.print();
        }

        for (int[] e : range1.difference(range2)) {
            for (int i = 0; i <= e.length - 1; ++i) {
                System.out.println(e[i]);
            }
        }

        for (int[] e : range1.union(range2)) {
            for (int i = 0; i <= e.length - 1; ++i) {
                System.out.println(e[i]);
            }
        }
    }
}

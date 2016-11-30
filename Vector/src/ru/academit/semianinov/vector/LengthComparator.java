package ru.academit.semianinov.vector;

import java.util.Comparator;

/**
 * Created by ZeSVeN on 30.11.2016.
 */
public class LengthComparator implements Comparator<Vector>{
    @Override
    public int compare(Vector vector1, Vector vector2) {
        return vector1.getLength() > vector2.getLength() ? 1 : vector1.getLength() < vector2.getLength() ? -1 : 0;
    }
}

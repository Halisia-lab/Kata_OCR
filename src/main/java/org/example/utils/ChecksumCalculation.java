package org.example.utils;

import java.util.Map;

public final class ChecksumCalculation {
    public final static int MODULO_VALUE = 11;
    public final static Map<Integer,Integer> indexPositionHelper = Map.of(
            0,9,
            1,8,
            2,7,
            3,6,
            4,5,
            5,4,
            6,3,
            7,2,
            8,1);
}

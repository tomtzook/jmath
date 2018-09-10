package com.jmath.util;

public class ArrayUnboxer {

    public static double[] unbox(Double[] arr) {
        double[] unboxed = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            unboxed[i] = arr[i];
        }

        return unboxed;
    }
}

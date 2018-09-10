package com.jmath;

public class Mathx {

    private Mathx() {}

    private static final double ROOT_DIFFERENCE = 1e-8;

    public static double root(double redicand, int degree){
        if(redicand < 0) {
            throw new IllegalArgumentException("Cannot calculate negative root of negative redicand");
        }
        if(redicand == 0) {
            return 0;
        }

        double x1 = redicand;
        double x2 = redicand / degree;
        while (Math.abs(x1 - x2) > ROOT_DIFFERENCE){
            x1 = x2;
            x2 = ((degree - 1.0) * x2 + redicand / Math.pow(x2, degree - 1.0)) / degree;
        }

        return x2;
    }
}

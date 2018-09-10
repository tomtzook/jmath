package com.jmath;

public class Mathx {

    private Mathx() {}

    private static final double ROOT_DIFFERENCE = 1e-8;

    public static double root(double radicand, int degree){
        if(radicand < 0) {
            throw new IllegalArgumentException("Cannot calculate negative root of negative radicand");
        }
        if(radicand == 0) {
            return 0;
        }

        double x1 = radicand;
        double x2 = radicand / degree;
        while (Math.abs(x1 - x2) > ROOT_DIFFERENCE){
            x1 = x2;
            x2 = ((degree - 1.0) * x2 + radicand / Math.pow(x2, degree - 1.0)) / degree;
        }

        return x2;
    }

    public static double roundToMultiplier(double value, double multiplier){
        return multiplier * Math.round(value / multiplier);
    }

    public static double roundToMultiplier(double value, double multiplier, boolean up){
        double rounded = roundToMultiplier(value, multiplier);
        if(rounded < value) {
            rounded += up ? multiplier : -multiplier;
        }

        return rounded;
    }
}

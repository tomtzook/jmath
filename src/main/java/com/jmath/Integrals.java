package com.jmath;

public final class Integrals {

    private Integrals() {}

    public static double trapezoidalRule(Function function, double min, double max, int trapezoids){
        double h = (max - min) / trapezoids;
        double s = 0.5 * (function.applyAsDouble(min) + function.applyAsDouble(max));

        for(int i = 1; i < trapezoids; i++) {
            s += function.applyAsDouble(min + i * h);
        }

        return (s * h);
    }

    public static double simpsonsRule(Function function, double min, double max, int slices){
        double h = (max - min) / slices;
        double s = function.applyAsDouble(min) + function.applyAsDouble(max);
        double s1 = 0;
        double s2 = 0;

        int halfSlices = slices / 2;
        for(int i = 1; i <= halfSlices; i++) {
            s1 += function.applyAsDouble(min + (2 * i - 1) * h);

            if(i < halfSlices) {
                s2 += function.applyAsDouble(min + 2 * i * h);
            }
        }

        return (1 / 3.0) * h * (s + 4 * s1 + 2 * s2);
    }
}

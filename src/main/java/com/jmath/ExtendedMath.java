package com.jmath;

public class ExtendedMath {

    private ExtendedMath() {}

    private static final double ROOT_DIFFERENCE = 1e-8;

    public static boolean equalsExact(double value1, double value2) {
        return Double.doubleToLongBits(value1) == Double.doubleToLongBits(value2);
    }

    public static boolean equals(double value1, double value2, double delta) {
        if (Double.compare(value1, value2) == 0) {
            return true;
        }

        return (Math.abs(value1 - value2) <= delta);
    }

    public static double avg(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        double sum = 0.0;

        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }

    public static double constrain(double value, double min, double max) {
        if (value < min) {
            return min;
        }

        if (value > max) {
            return max;
        }

        return value;
    }

    public static boolean constrained(double value, double min, double max){
        return value >= min && value <= max;
    }

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
        if(rounded < value && up) {
            rounded += multiplier;
        } else if (rounded > value && !up) {
            rounded -= multiplier;
        }

        return rounded;
    }
}

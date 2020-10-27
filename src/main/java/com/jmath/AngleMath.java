package com.jmath;

import com.jmath.vectors.Vector3;

public final class AngleMath {

    private AngleMath() {}

    public static boolean equals(double value1, double value2) {
        value1 = translate(value1);
        value2 = translate(value2);

        return ExtendedMath.equals(value1, value2, 0.1);
    }

    public static double shortestAngularDistance(double from, double to) {
        Vector3 currentVector = new Vector3(from - 360.0, from, from + 360.0);

        Vector3 diffVector = currentVector.sub(to);
        double result = diffVector.abs().min();

        if (result > 180.0) {
            result = Math.signum(result) * (360.0 - result);
        }

        return result;
    }

    public static double translate(double value) {
        value %= 360.0;
        if (value < 0.0) {
            value += 360.0;
        }

        if (value - 360.0 == 0) {
            return 0.0;
        }

        return value;
    }

    public static int motionDirection(double from, double to) {
        from = translate(from);
        to = translate(to);

        if (from == to) {
            return 1;
        }

        double max = Math.max(from, to);
        double min = Math.min(from, to);

        if (max - min < 180) {
            return max == to ? 1 : -1;
        }
        if (360 - max + min < 180) {
            return max == to ? -1 : 1;
        }

        if (max == from && max - min < 180) {
            return -1;
        }

        if (max == to && Math.abs(max - min) > 180) {
            return -1;
        }

        return 1;
    }
}

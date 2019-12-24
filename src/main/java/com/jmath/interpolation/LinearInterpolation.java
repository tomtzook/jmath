package com.jmath.interpolation;

import com.jmath.ExtendedMath;

import java.util.Map;

public class LinearInterpolation implements Interpolation {
    
    private final Map<Double, Double> mValues;
    private final double mKeyMargin;

    public LinearInterpolation(Map<Double, Double> values, double keyMargin) {
        mValues = values;
        mKeyMargin = keyMargin;
    }

    @Override
    public double applyAsDouble(double x2) {
        if(mValues.containsKey(x2)) {
            return mValues.get(x2);
        }

        double x1 = findClosestKey(x2, false);
        double x3 = findClosestKey(x2, true);
        double y1 = mValues.get(x1);
        double y3 = mValues.get(x3);
        return (((x2 - x1) * (y3 - y1)) / (x3 - x1)) + y1;
    }

    private double findClosestKey(double original, boolean above) {
        double value = ExtendedMath.roundToMultiplier(original, mKeyMargin, above);
        while (!mValues.containsKey(value)) {
            value = ExtendedMath.roundToMultiplier(value, mKeyMargin, above);
        }

        return value;
    }
}

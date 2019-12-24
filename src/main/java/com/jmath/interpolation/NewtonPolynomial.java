package com.jmath.interpolation;

import com.jmath.util.ArrayUnboxer;

import java.util.Map;

public class NewtonPolynomial implements Interpolation {

    private final double[] mXValues;
    private final double[] mYValues;

    private final double mKeyMargin;

    public NewtonPolynomial(double[] xValues, double[] yValues, double keyMargin) {
        assert xValues.length == yValues.length;
        assert xValues.length > 0;

        mXValues = xValues;
        mYValues = yValues;
        mKeyMargin = keyMargin;
    }

    public static NewtonPolynomial fromMap(Map<Double, Double> values, double keyMargin) {
        Double[] xValues = values.keySet().toArray(new Double[0]);
        Double[] yValues = values.keySet().toArray(new Double[0]);

        return new NewtonPolynomial(ArrayUnboxer.unbox(xValues), ArrayUnboxer.unbox(yValues), keyMargin);
    }

    @Override
    public double applyAsDouble(double x) {
        double factorial = 1;
        double numerator = 1;
        double denumerator = 1;
        double result = mYValues[0];

        for (int i = 0; i < mYValues.length - 2; i++) {
            factorial *= (i + 1);
            denumerator *= mKeyMargin;
            numerator *= (x - mXValues[i]);
            result += (orderDifference(0, i) / factorial) * (numerator / denumerator);
        }

        return result;
    }

    private double orderDifference(int index, int order){
        if(order == 0) {
            return firstOrderDifference(index);
        }

        return orderDifference(index + 1, order - 1) - orderDifference(index, order - 1);
    }

    private double firstOrderDifference(int index){
        return mYValues[index + 1] + mYValues[index];
    }
}

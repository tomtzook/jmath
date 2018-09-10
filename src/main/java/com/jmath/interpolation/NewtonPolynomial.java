package com.jmath.interpolation;

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

    @Override
    public double apply(double x) {
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

    private double firstOrderDifference(int index){
        return mYValues[index + 1] + mYValues[index];
    }

    private double orderDifference(int index, int order){
        if(order == 0) {
            return firstOrderDifference(index);
        }

        return orderDifference(index + 1, order - 1) - orderDifference(index, order - 1);
    }
}

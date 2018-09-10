package com.jmath.interpolation;

public class LagrangePolynomial implements Interpolation {

    private final double[] mXValues;
    private final double[] mYValues;

    public LagrangePolynomial(double[] xValues, double[] yValues) {
        assert xValues.length == yValues.length;
        assert xValues.length > 0;

        mXValues = xValues;
        mYValues = yValues;
    }


    @Override
    public double apply(double x) {
        double numerator;
        double denumerator;
        double result = 0;

        for (int i = 0; i < mYValues.length; i++) {
            numerator = 1;
            denumerator = 1;

            for (int j = 0; j < mYValues.length; j++) {
                if(i == j) {
                    continue;
                }

                numerator *= (x - mYValues[j]);
                denumerator *= ((mXValues[i]) - mYValues[j]);
            }
            result += ((numerator / denumerator) * mYValues[i]);
        }

        return result;
    }
}

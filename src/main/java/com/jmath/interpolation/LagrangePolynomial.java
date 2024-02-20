package com.jmath.interpolation;

import com.jmath.util.ArrayUnboxer;

import java.util.Map;

public class LagrangePolynomial implements Interpolation {

    private final double[] mXValues;
    private final double[] mYValues;

    public LagrangePolynomial(double[] xValues, double[] yValues) {
        assert xValues.length == yValues.length;
        assert xValues.length > 0;

        mXValues = xValues;
        mYValues = yValues;
    }

    public static LagrangePolynomial fromMap(Map<Double, Double> values) {
        Double[] xValues = values.keySet().toArray(new Double[0]);
        Double[] yValues = values.values().toArray(new Double[0]);

        return new LagrangePolynomial(ArrayUnboxer.unbox(xValues), ArrayUnboxer.unbox(yValues));
    }

    @Override
    public double applyAsDouble(double x) {
        double result = 0;

        for (int i = 0; i < mYValues.length; i++) {
            double term = mYValues[i];
            for (int j = 0; j < mYValues.length; j++) {
                if (j == i)
                    continue;

                term *= (x - mXValues[j]) / (mXValues[i] - mXValues[j]);
            }

            result += term;
        }

        return result;
    }
}

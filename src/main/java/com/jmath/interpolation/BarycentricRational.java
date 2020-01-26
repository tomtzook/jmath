package com.jmath.interpolation;

import com.jmath.ExtendedMath;
import com.jmath.util.ArrayUnboxer;

import java.util.Map;

public class BarycentricRational implements Interpolation {

    private final double[] mXValues;
    private final double[] mYValues;
    private final double[] mWeights;
    private final int mNodes;

    public BarycentricRational(double[] xValues, double[] yValues, double[] weights) {
        assert xValues.length == yValues.length;
        assert xValues.length == weights.length;
        assert xValues.length > 0;

        mXValues = xValues;
        mYValues = yValues;
        mWeights = weights;
        mNodes = mWeights.length;
    }

    public static BarycentricRational fromMap(Map<Double, Double> points, int d) {
        double[] xValues = ArrayUnboxer.unbox(points.keySet().toArray(new Double[0]));
        double[] yValues = ArrayUnboxer.unbox(points.values().toArray(new Double[0]));
        double[] weights = calculateWeights(xValues, d);

        return new BarycentricRational(xValues, yValues, weights);
    }

    @Override
    public double applyAsDouble(double operand) {
        double numerator = 0;
        double denumerator = 0;

        for (int i = 0; i < mNodes; i++) {
            double value = mWeights[i] / (operand - mXValues[i]);
            numerator += value * mYValues[i];
            denumerator += value;
        }

        return numerator / denumerator;
    }

    public static double[] calculateWeights(double[] xValues, int d) {
        double[] weights = new double[xValues.length];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = calculateWeight(xValues, i, d);
        }

        return weights;
    }

    private static double calculateWeight(double[] xValues, int k, int d) {
        double weight = 0;
        for (int i = k - d; i < k; i++) {
            if (!ExtendedMath.constrained(i, 0, xValues.length - d)) {
                continue;
            }

            double product = Math.pow(-1, k);
            for (int j = i; j < (i + d); j++) {
                if (j == k) {
                    continue;
                }

                product *= 1 / (xValues[k] - xValues[j]);
            }

            weight += product;
        }

        return weight;
    }
}

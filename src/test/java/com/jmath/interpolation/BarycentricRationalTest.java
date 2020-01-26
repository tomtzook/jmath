package com.jmath.interpolation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

import static org.junit.Assert.*;

public class BarycentricRationalTest {

    @Test
    public void applyAsDouble_forSimpleFunction_producesExpectedResult() throws Exception {
        BarycentricRational interpolation = BarycentricRational.fromMap(createPointMapFromFunction(
                (x)->(x * x + 2) / (x * x + 2),
                5.0,
                15), 3);

        double result = interpolation.applyAsDouble(17);
        assertEquals(1, result, 0.001);
    }

    private static Map<Double, Double> createPointMapFromFunction(DoubleUnaryOperator function, double pointXDifference, int points) {
        Map<Double, Double> map = new HashMap<>();

        double x = 0;
        for (int i = 0; i < points; i++) {
            x += pointXDifference;
            map.put(x, function.applyAsDouble(x));
        }

        return map;
    }
}
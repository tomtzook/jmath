package com.jmath.interpolation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarycentricRationalTest {

    @ParameterizedTest(name = "f({0})")
    @CsvSource({
            "123", "17", "34",
            "61", "8", "43",
            "-3"
    })
    public void applyAsDouble_forSimpleFunction_producesExpectedResult(double xValue) throws Exception {
        final double ACCURACY = 0.5;

        DoubleUnaryOperator function = (x)->(x*x*x-2*x)/(2*(x*x-5));
        final double expectedResult = function.applyAsDouble(xValue);

        BarycentricRational interpolation = BarycentricRational.fromMap(createPointMapFromFunction(
                function,
                -10.0, 5.0, 50), 2);

        double result = interpolation.applyAsDouble(xValue);
        assertEquals(expectedResult, result, ACCURACY,
                String.format("interpolate(%.3f) = %.3f !=! f(%.3f) = %.3f",
                        xValue, result, xValue, expectedResult));
    }

    private static Map<Double, Double> createPointMapFromFunction(DoubleUnaryOperator function, double initialValue,
                                                                  double pointXDifference, int points) {
        Map<Double, Double> map = new HashMap<>();

        double x = initialValue;
        for (int i = 0; i < points; i++) {
            x += pointXDifference;
            map.put(x, function.applyAsDouble(x));
        }

        return map;
    }
}
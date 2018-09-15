package com.jmath;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathxTest {

    private static final double MAX_DIFFERENCE_MARGIN = 1e-8;

    @Test
    public void root_secondDegree_expectedResult() throws Exception {
        final double RADICAND = 25.0;
        final double RESULT = 5.0;

        double result = Mathx.root(RADICAND, 2);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void root_thirdDegree_expectedResult() throws Exception {
        final double RADICAND = 125.0;
        final double RESULT = 5.0;

        double result = Mathx.root(RADICAND, 3);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void roundToMultiplier_roundUpwards_expectedResult() throws Exception {
        final double VALUE = 1.0;
        final double MULTIPLIER = 5.0;
        final double RESULT = 5.0;

        double result = Mathx.roundToMultiplier(VALUE, MULTIPLIER, true);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void roundToMultiplier_roundDownwards_expectedResult() throws Exception {
        final double VALUE = 1.0;
        final double MULTIPLIER = 5.0;
        final double RESULT = 0.0;

        double result = Mathx.roundToMultiplier(VALUE, MULTIPLIER, false);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void roundToMultiplier_valueDivisibleByMultiplier_returnsSameValue() throws Exception {
        final double VALUE = 5.0;
        final double MULTIPLIER = 5.0;

        double result = Mathx.roundToMultiplier(VALUE, MULTIPLIER);
        assertDoubleEquals(VALUE, result);
    }

    private static void assertDoubleEquals(double expected, double actual) {
        assertEquals(
                String.format("expected: %f actual: %f", expected, actual),
                Double.doubleToLongBits(expected),
                Double.doubleToLongBits(actual));
    }

    private static void assertDoubleEqualsWithMargin(double expected, double actual) {
        assertTrue(
                String.format("expected: %f actual: %f", expected, actual),
                expected > actual - MAX_DIFFERENCE_MARGIN &&
                        expected < actual + MAX_DIFFERENCE_MARGIN);
    }
}
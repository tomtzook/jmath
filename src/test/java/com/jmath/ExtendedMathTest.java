package com.jmath;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExtendedMathTest {

    private static final double MAX_DIFFERENCE_MARGIN = 1e-8;

    @Test
    public void equals_numbersAreWithinMarginDifference_returnsTrue() throws Exception {
        final double VALUE1 = 5.2231;
        final double VALUE2 = 5.2233;
        final double DELTA = 0.0005;

        assertTrue(ExtendedMath.equals(VALUE1, VALUE2, DELTA));
    }

    @Test
    public void equals_numbersAreOutOfMarginDifference_returnsFalse() throws Exception {
        final double VALUE1 = 5.2231;
        final double VALUE2 = 5.2233;
        final double DELTA = 0.0001;

        assertFalse(ExtendedMath.equals(VALUE1, VALUE2, DELTA));
    }

    @Test
    public void equalsExact_numbersAreExactlyTheSame_returnsTrue() throws Exception {
        final double VALUE1 = 5.2314353;
        final double VALUE2 = 5.2314353;

        assertTrue(ExtendedMath.equalsExact(VALUE1, VALUE2));
    }

    @Test
    public void equalsExact_numbersAreNotTheSame_returnsFalse() throws Exception {
        final double VALUE1 = 5.2314353;
        final double VALUE2 = 5.2314352;

        assertFalse(ExtendedMath.equalsExact(VALUE1, VALUE2));
    }

    @Test
    public void avg_forIntegerNumbers_calculatesCorrectAverage() throws Exception {
        final double[] NUMBERS = {
                5.0, 6.0, 7.0
        };
        final double AVG = 6.0;

        assertDoubleEqualsExact(AVG, ExtendedMath.avg(NUMBERS));
    }

    @Test
    public void avg_forDoubleNumbers_calculatesCorrectAverage() throws Exception {
        final double[] NUMBERS = {
                5.5, 6.4, 10.8
        };
        final double AVG = 7.566666667;

        assertEquals(AVG, ExtendedMath.avg(NUMBERS), 0.001);
    }

    @Test
    public void avg_forSingleNumber_returnsThatNumber() throws Exception {
        final double[] NUMBERS = {
                5.5,
        };
        final double AVG = 5.5;

        assertDoubleEqualsExact(AVG, ExtendedMath.avg(NUMBERS));
    }

    @Test(expected = IllegalArgumentException.class)
    public void avg_forEmptyArray_throwsIllegalArgumentException() throws Exception {
        final double[] NUMBERS = {
        };

        ExtendedMath.avg(NUMBERS);
    }

    @Test
    public void constrain_valueWithinBounds_returnsSameValue() throws Exception {
        final double VALUE = 5.0;
        final double MIN = 1.0;
        final double MAX = 10.0;

        assertDoubleEqualsExact(VALUE, ExtendedMath.constrain(VALUE, MIN, MAX));
    }

    @Test
    public void constrain_valueOutOfLowerBounds_returnsLowerBound() throws Exception {
        final double VALUE = -4.0;
        final double MIN = 1.0;
        final double MAX = 10.0;

        assertDoubleEqualsExact(MIN, ExtendedMath.constrain(VALUE, MIN, MAX));
    }

    @Test
    public void constrain_valueOutOfUpperBounds_returnsUpperBound() throws Exception {
        final double VALUE = 13.0;
        final double MIN = 1.0;
        final double MAX = 10.0;

        assertDoubleEqualsExact(MAX, ExtendedMath.constrain(VALUE, MIN, MAX));
    }

    @Test
    public void constrained_valueWithinBounds_returnsTrue() throws Exception {
        final double VALUE = 5.0;
        final double MIN = 1.0;
        final double MAX = 10.0;

        assertTrue(ExtendedMath.constrained(VALUE, MIN, MAX));
    }

    @Test
    public void constrained_valueOutOfLowerBounds_returnsFalse() throws Exception {
        final double VALUE = -4.0;
        final double MIN = 1.0;
        final double MAX = 10.0;

        assertFalse(ExtendedMath.constrained(VALUE, MIN, MAX));
    }

    @Test
    public void constrained_valueOutOfUpperBounds_returnsFalse() throws Exception {
        final double VALUE = 13.0;
        final double MIN = 1.0;
        final double MAX = 10.0;

        assertFalse(ExtendedMath.constrained(VALUE, MIN, MAX));
    }

    @Test
    public void root_secondDegree_expectedResult() throws Exception {
        final double RADICAND = 25.0;
        final double RESULT = 5.0;

        double result = ExtendedMath.root(RADICAND, 2);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void root_thirdDegree_expectedResult() throws Exception {
        final double RADICAND = 125.0;
        final double RESULT = 5.0;

        double result = ExtendedMath.root(RADICAND, 3);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void roundToMultiplier_roundUpwards_expectedResult() throws Exception {
        final double VALUE = 1.0;
        final double MULTIPLIER = 5.0;
        final double RESULT = 5.0;

        double result = ExtendedMath.roundToMultiplier(VALUE, MULTIPLIER, true);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void roundToMultiplier_roundDownwards_expectedResult() throws Exception {
        final double VALUE = 1.0;
        final double MULTIPLIER = 5.0;
        final double RESULT = 0.0;

        double result = ExtendedMath.roundToMultiplier(VALUE, MULTIPLIER, false);
        assertDoubleEqualsWithMargin(RESULT, result);
    }

    @Test
    public void roundToMultiplier_valueDivisibleByMultiplier_returnsSameValue() throws Exception {
        final double VALUE = 5.0;
        final double MULTIPLIER = 5.0;

        double result = ExtendedMath.roundToMultiplier(VALUE, MULTIPLIER);
        assertDoubleEqualsExact(VALUE, result);
    }

    private static void assertDoubleEqualsExact(double expected, double actual) {
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
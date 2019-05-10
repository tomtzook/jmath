package com.jmath.util.function;

import com.jmath.ExtendedMath;

import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

public class FunctionalMath {

    private FunctionalMath() {}

    public static DoubleUnaryOperator constrain(double min, double max) {
        return (value) -> ExtendedMath.constrain(value, min, max);
    }

    public static DoublePredicate constrained(double min, double max) {
        return (value) -> ExtendedMath.constrained(value, min, max);
    }

    public static DoublePredicate largerThan(double value) {
        return (someValue) -> someValue > value;
    }

    public static DoublePredicate largerOrEqualsTo(double value) {
        return (someValue) -> someValue >= value;
    }

    public static DoublePredicate absLargerThan(double value) {
        return (someValue) -> Math.abs(someValue) > value;
    }

    public static DoublePredicate absLargerOrEqualsTo(double value) {
        return (someValue) -> Math.abs(someValue) >= value;
    }

    public static DoublePredicate smallerThan(double value) {
        return (someValue) -> someValue < value;
    }

    public static DoublePredicate smallerEqualsTo(double value) {
        return (someValue) -> someValue <= value;
    }

    public static DoublePredicate absSmallerThan(double value) {
        return (someValue) -> Math.abs(someValue) < value;
    }

    public static DoublePredicate absSmallerOrEqualsTo(double value) {
        return (someValue) -> Math.abs(someValue) <= value;
    }

    public static DoublePredicate equalsTo(double value) {
        return (someValue) -> someValue == value;
    }
}

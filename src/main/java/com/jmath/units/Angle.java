package com.jmath.units;

import java.util.Objects;

public class Angle implements Comparable<Angle> {

    private final double mValue;
    private final AngleUnit mUnit;

    public Angle(double value, AngleUnit unit) {
        mValue = value;
        mUnit = Objects.requireNonNull(unit, "unit");
    }

    public static Angle of(double value, AngleUnit unit) {
        return new Angle(value, unit);
    }

    public static Angle degrees(double value) {
        return new Angle(value, AngleUnit.DEGREES);
    }

    public static Angle radians(double value) {
        return new Angle(value, AngleUnit.RADIANS);
    }

    public double value() {
        return mValue;
    }

    public AngleUnit unit() {
        return mUnit;
    }

    public Angle constrainInCircle() {
        double translatedValue = mValue % mUnit.fullCircle();
        if (translatedValue < 0) {
            translatedValue += mUnit.fullCircle();
        }

        return new Angle(translatedValue, mUnit);
    }

    public Angle toUnit(AngleUnit unit) {
        double newValue = unit.convertFrom(mValue, mUnit);
        return new Angle(newValue, unit);
    }

    public Angle add(Angle other) {
        double newValue = mValue + other.toUnit(mUnit).value();
        return new Angle(newValue, mUnit);
    }

    public Angle sub(Angle other) {
        double newValue = mValue - other.toUnit(mUnit).value();
        return new Angle(newValue, mUnit);
    }

    public Angle multiply(Angle other) {
        double newValue = mValue * other.toUnit(mUnit).value();
        return new Angle(newValue, mUnit);
    }

    public Angle divide(Angle other) {
        double newValue = mValue / other.toUnit(mUnit).value();
        return new Angle(newValue, mUnit);
    }

    public boolean equals(Angle other) {
        return compareTo(other) == 0;
    }

    public boolean smaller(Angle other) {
        return compareTo(other) < 0;
    }

    public boolean bigger(Angle other) {
        return compareTo(other) > 0;
    }

    @Override
    public int compareTo(Angle o) {
        double otherValue = o.toUnit(mUnit).value();

        if (mValue == otherValue) {
            return 0;
        }

        return (int) Math.signum(mValue - otherValue);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Angle && equals((Angle)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mValue, mUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f [%s]", mValue, mUnit);
    }

    public static Angle min(Angle angle1, Angle angle2) {
        return angle2.smaller(angle1) ? angle2 : angle1;
    }

    public static Angle max(Angle angle1, Angle angle2) {
        return angle2.bigger(angle1) ? angle2 : angle1;
    }
}

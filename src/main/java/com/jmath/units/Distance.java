package com.jmath.units;

import java.util.Objects;

public class Distance implements Comparable<Distance> {

    private final double mValue;
    private final DistanceUnit mUnit;

    public Distance(double value, DistanceUnit unit) {
        mValue = value;
        mUnit = unit;
    }

    public static Distance centimeters(double value) {
        return new Distance(value, DistanceUnit.CM);
    }

    public static Distance meters(double value) {
        return new Distance(value, DistanceUnit.METERS);
    }

    public static Distance inches(double value) {
        return new Distance(value, DistanceUnit.INCHES);
    }

    public double value() {
        return mValue;
    }

    public DistanceUnit unit() {
        return mUnit;
    }

    public Distance toUnit(DistanceUnit unit) {
        if (mUnit == unit) {
            return this;
        }

        double newValue = unit.convertFrom(mValue, mUnit);
        return new Distance(newValue, unit);
    }

    public Distance add(Distance other) {
        double newValue = mValue + other.toUnit(mUnit).value();
        return new Distance(newValue, mUnit);
    }

    public Distance sub(Distance other) {
        double newValue = mValue - other.toUnit(mUnit).value();
        return new Distance(newValue, mUnit);
    }

    public Distance multiply(Distance other) {
        double newValue = mValue * other.toUnit(mUnit).value();
        return new Distance(newValue, mUnit);
    }

    public Distance divide(Distance other) {
        double newValue = mValue / other.toUnit(mUnit).value();
        return new Distance(newValue, mUnit);
    }

    public boolean equals(Distance other) {
        return compareTo(other) == 0;
    }

    public boolean smaller(Distance other) {
        return compareTo(other) < 0;
    }

    public boolean larger(Distance other) {
        return compareTo(other) > 0;
    }

    @Override
    public int compareTo(Distance o) {
        double otherValue = o.toUnit(mUnit).value();

        if (mValue == otherValue) {
            return 0;
        }

        return (int) Math.signum(mValue - otherValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Distance) {
            return equals((Distance)obj);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mValue, mUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f [%s]", mValue, mUnit.name());
    }
}

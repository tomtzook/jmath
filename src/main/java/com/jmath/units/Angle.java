package com.jmath.units;

import java.util.Objects;

public class Angle implements Comparable<Angle> {

    private final double mValue;
    private final AngleUnit mUnit;

    public Angle(double value, AngleUnit unit) {
        mValue = value;
        mUnit = unit;
    }

    public double value() {
        return mValue;
    }

    public AngleUnit unit() {
        return mUnit;
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
        if (obj instanceof Angle) {
            return equals((Angle)obj);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mValue, mUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f [%s]", mValue, mUnit);
    }
}

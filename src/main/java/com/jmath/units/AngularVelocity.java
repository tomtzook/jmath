package com.jmath.units;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class AngularVelocity implements Comparable<AngularVelocity> {

    private final double mValue;
    private final AngleUnit mAngleUnit;
    private final TimeUnit mTimeUnit;

    public AngularVelocity(double value, AngleUnit angleUnit, TimeUnit timeUnit) {
        mValue = value;
        mAngleUnit = angleUnit;
        mTimeUnit = timeUnit;
    }

    public static AngularVelocity of(double value, AngleUnit angleUnit, TimeUnit timeUnit) {
        return new AngularVelocity(value, angleUnit, timeUnit);
    }

    public static AngularVelocity degreesPerSeconds(double value) {
        return of(value, AngleUnit.DEGREES, TimeUnit.SECONDS);
    }

    public static AngularVelocity radiansPerSeconds(double value) {
        return of(value, AngleUnit.RADIANS, TimeUnit.SECONDS);
    }

    public double value() {
        return mValue;
    }

    public AngleUnit angleUnit() {
        return mAngleUnit;
    }

    public TimeUnit timeUnit() {
        return mTimeUnit;
    }

    public AngularVelocity toUnits(AngleUnit angleUnit, TimeUnit timeUnit) {
        double distanceValue = angleUnit.convertFrom(mValue, mAngleUnit);
        double timeConversionRatio = (double) mTimeUnit.toNanos(1) / (double) timeUnit.toNanos(1);

        return new AngularVelocity(distanceValue * timeConversionRatio, angleUnit, timeUnit);
    }

    public AngularVelocity abs() {
        return new AngularVelocity(Math.abs(mValue), mAngleUnit, mTimeUnit);
    }

    public AngularVelocity add(AngularVelocity other) {
        double newValue = mValue + other.toUnits(mAngleUnit, mTimeUnit).value();
        return new AngularVelocity(newValue, mAngleUnit, mTimeUnit);
    }

    public AngularVelocity sub(AngularVelocity other) {
        double newValue = mValue - other.toUnits(mAngleUnit, mTimeUnit).value();
        return new AngularVelocity(newValue, mAngleUnit, mTimeUnit);
    }

    public AngularVelocity multiply(AngularVelocity other) {
        double newValue = mValue * other.toUnits(mAngleUnit, mTimeUnit).value();
        return new AngularVelocity(newValue, mAngleUnit, mTimeUnit);
    }

    public AngularVelocity divide(AngularVelocity other) {
        double newValue = mValue / other.toUnits(mAngleUnit, mTimeUnit).value();
        return new AngularVelocity(newValue, mAngleUnit, mTimeUnit);
    }

    public boolean equals(AngularVelocity other) {
        return compareTo(other) == 0;
    }

    public boolean faster(AngularVelocity other) {
        return compareTo(other) > 0;
    }

    public boolean slower(AngularVelocity other) {
        return compareTo(other) < 0;
    }

    @Override
    public int compareTo(AngularVelocity other) {
        double otherValue = other.toUnits(mAngleUnit, mTimeUnit).value();

        if (mValue == otherValue) {
            return 0;
        }

        return (int) Math.signum(mValue - otherValue);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AngularVelocity && equals((AngularVelocity)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mValue, mAngleUnit, mTimeUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f [%s/%s]", mValue, mAngleUnit.name(), mTimeUnit.name());
    }

    public static AngularVelocity min(AngularVelocity angularVelocity1, AngularVelocity angularVelocity2) {
        if (angularVelocity2.slower(angularVelocity1)) {
            return angularVelocity2;
        }

        return angularVelocity1;
    }

    public static AngularVelocity max(AngularVelocity angularVelocity1, AngularVelocity angularVelocity2) {
        if (angularVelocity2.faster(angularVelocity1)) {
            return angularVelocity2;
        }

        return angularVelocity1;
    }
}

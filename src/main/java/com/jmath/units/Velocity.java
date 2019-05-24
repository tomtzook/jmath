package com.jmath.units;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Velocity implements Comparable<Velocity> {

    private final double mValue;
    private final DistanceUnit mDistanceUnit;
    private final TimeUnit mTimeUnit;

    public Velocity(double value, DistanceUnit distanceUnit, TimeUnit timeUnit) {
        mValue = value;
        mDistanceUnit = distanceUnit;
        mTimeUnit = timeUnit;
    }

    public static Velocity of(double value, DistanceUnit distanceUnit, TimeUnit timeUnit) {
        return new Velocity(value, distanceUnit, timeUnit);
    }

    public static Velocity metersPerSeconds(double value) {
        return of(value, DistanceUnit.METERS, TimeUnit.SECONDS);
    }

    public double value() {
        return mValue;
    }

    public DistanceUnit distanceUnit() {
        return mDistanceUnit;
    }

    public TimeUnit timeUnit() {
        return mTimeUnit;
    }

    public Velocity toUnits(DistanceUnit distanceUnit, TimeUnit timeUnit) {
        double distanceValue = distanceUnit.convertFrom(mValue, mDistanceUnit);
        double timeConversionRatio = (double) mTimeUnit.toNanos(1) / (double) timeUnit.toNanos(1);

        return new Velocity(distanceValue * timeConversionRatio, distanceUnit, timeUnit);
    }

    public Velocity abs() {
        return new Velocity(Math.abs(mValue), mDistanceUnit, mTimeUnit);
    }

    public Velocity add(Velocity other) {
        double newValue = mValue + other.toUnits(mDistanceUnit, mTimeUnit).value();
        return new Velocity(newValue, mDistanceUnit, mTimeUnit);
    }

    public Velocity sub(Velocity other) {
        double newValue = mValue - other.toUnits(mDistanceUnit, mTimeUnit).value();
        return new Velocity(newValue, mDistanceUnit, mTimeUnit);
    }

    public Velocity multiply(Velocity other) {
        double newValue = mValue * other.toUnits(mDistanceUnit, mTimeUnit).value();
        return new Velocity(newValue, mDistanceUnit, mTimeUnit);
    }

    public Velocity divide(Velocity other) {
        double newValue = mValue / other.toUnits(mDistanceUnit, mTimeUnit).value();
        return new Velocity(newValue, mDistanceUnit, mTimeUnit);
    }

    public boolean equals(Velocity other) {
        return compareTo(other) == 0;
    }

    public boolean faster(Velocity other) {
        return compareTo(other) > 0;
    }

    public boolean slower(Velocity other) {
        return compareTo(other) < 0;
    }

    @Override
    public int compareTo(Velocity other) {
        double otherValue = other.toUnits(mDistanceUnit, mTimeUnit).value();

        if (mValue == otherValue) {
            return 0;
        }

        return (int) Math.signum(mValue - otherValue);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Velocity && equals((Velocity)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mValue, mDistanceUnit, mTimeUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f [%s/%s]", mValue, mDistanceUnit.name(), mTimeUnit.name());
    }

    public static Velocity min(Velocity velocity1, Velocity velocity2) {
        if (velocity2.slower(velocity1)) {
            return velocity2;
        }

        return velocity1;
    }

    public static Velocity max(Velocity velocity1, Velocity velocity2) {
        if (velocity2.faster(velocity1)) {
            return velocity2;
        }

        return velocity1;
    }
}

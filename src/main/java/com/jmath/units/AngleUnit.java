package com.jmath.units;

public enum AngleUnit {
    DEGREES {
        @Override
        double toDegrees(double value) { return value; }
        @Override
        double toRadians(double value) { return Math.toRadians(value); }

        @Override
        double convertFrom(double value, AngleUnit fromUnit) {
            return fromUnit.toDegrees(value);
        }

        @Override
        double fullCircle() {
            return 360.0;
        }
    },
    RADIANS {
        @Override
        double toDegrees(double value) { return Math.toDegrees(value); }
        @Override
        double toRadians(double value) { return value; }

        @Override
        double convertFrom(double value, AngleUnit fromUnit) {
            return fromUnit.toRadians(value);
        }

        @Override
        double fullCircle() {
            return 2 * Math.PI;
        }
    };

    abstract double toDegrees(double value);
    abstract double toRadians(double value);

    abstract double convertFrom(double value, AngleUnit fromUnit);

    abstract double fullCircle();
}

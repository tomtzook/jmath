package com.jmath.units;

public enum AngleUnit {
    DEGREES {
        @Override
        public double toDegrees(double value) { return value; }
        @Override
        public double toRadians(double value) { return Math.toRadians(value); }

        @Override
        public double convertFrom(double value, AngleUnit fromUnit) {
            return fromUnit.toDegrees(value);
        }

        @Override
        public double fullCircle() {
            return 360.0;
        }
    },
    RADIANS {
        @Override
        public double toDegrees(double value) { return Math.toDegrees(value); }
        @Override
        public double toRadians(double value) { return value; }

        @Override
        public double convertFrom(double value, AngleUnit fromUnit) {
            return fromUnit.toRadians(value);
        }

        @Override
        public double fullCircle() {
            return 2 * Math.PI;
        }
    };

    public abstract double toDegrees(double value);
    public abstract double toRadians(double value);

    public abstract double convertFrom(double value, AngleUnit fromUnit);

    public abstract double fullCircle();
}

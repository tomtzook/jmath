package com.jmath.units;

public enum DistanceUnit {
    MM {
        @Override
        public double toMillimeters(double value) { return value; }
        @Override
        public double toCentimeters(double value) { return value * 0.1; }
        @Override
        public double toMeters(double value) { return value * 10e-3; }
        @Override
        public double toKilometers(double value) { return value * 10e-6; }
        @Override
        public double toInches(double value) { return value / 25.4; }
        @Override
        public double toFeet(double value) { return value / 304.8; }
        @Override
        public double toYards(double value) { return value / 914.4; }
        @Override
        public double toMiles(double value) { return value / 1.609 * 10e-6; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toMillimeters(value);
        }
    },
    CM {
        @Override
        public double toMillimeters(double value) { return value * 10; }
        @Override
        public double toCentimeters(double value) { return value; }
        @Override
        public double toMeters(double value) { return value * 10e-2; }
        @Override
        public double toKilometers(double value) { return value * 10e-5; }
        @Override
        public double toInches(double value) { return value / 2.54; }
        @Override
        public double toFeet(double value) { return value / 30.48; }
        @Override
        public double toYards(double value) { return value / 91.44; }
        @Override
        public double toMiles(double value) { return value / 1.609 * 10e-5; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toCentimeters(value);
        }
    },
    METERS {
        @Override
        public double toMillimeters(double value) { return value * 10e3; }
        @Override
        public double toCentimeters(double value) { return value * 100; }
        @Override
        public double toMeters(double value) { return value; }
        @Override
        public double toKilometers(double value) { return value * 10e-3; }
        @Override
        public double toInches(double value) { return value * 39.37; }
        @Override
        public double toFeet(double value) { return value * 3.281; }
        @Override
        public double toYards(double value) { return value * 1.094; }
        @Override
        public double toMiles(double value) { return value / 1.609 * 10e-3; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toMeters(value);
        }
    },
    KM {
        @Override
        public double toMillimeters(double value) { return value * 10e6; }
        @Override
        public double toCentimeters(double value) { return value * 10e4; }
        @Override
        public double toMeters(double value) { return value * 10e3; }
        @Override
        public double toKilometers(double value) { return value; }
        @Override
        public double toInches(double value) { return value * 3.937 * 10e4; }
        @Override
        public double toFeet(double value) { return value * 3.28 * 10e3; }
        @Override
        public double toYards(double value) { return value * 1.093 * 10e3; }
        @Override
        public double toMiles(double value) { return value / 1.609; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toKilometers(value);
        }
    },
    INCHES {
        @Override
        public double toMillimeters(double value) { return value * 25.4; }
        @Override
        public double toCentimeters(double value) { return value * 2.54; }
        @Override
        public double toMeters(double value) { return value / 39.37; }
        @Override
        public double toKilometers(double value) { return value / 3.937 * 10e-4; }
        @Override
        public double toInches(double value) { return value; }
        @Override
        public double toFeet(double value) { return value / 12; }
        @Override
        public double toYards(double value) { return value / 36; }
        @Override
        public double toMiles(double value) { return value / 6.3 * 10e-4; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toInches(value);
        }
    },
    FEET {
        @Override
        public double toMillimeters(double value) { return value * 304.8; }
        @Override
        public double toCentimeters(double value) { return value * 30.48; }
        @Override
        public double toMeters(double value) { return value / 3.281; }
        @Override
        public double toKilometers(double value) { return value / 3.28 * 10e-3; }
        @Override
        public double toInches(double value) { return value * 12; }
        @Override
        public double toFeet(double value) { return value; }
        @Override
        public double toYards(double value) { return value / 3; }
        @Override
        public double toMiles(double value) { return value / 5280; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toFeet(value);
        }
    },
    YARDS {
        @Override
        public double toMillimeters(double value) { return value * 914.4; }
        @Override
        public double toCentimeters(double value) { return value * 91.44; }
        @Override
        public double toMeters(double value) { return value / 1.094; }
        @Override
        public double toKilometers(double value) { return value / 1.093 * 10e-3; }
        @Override
        public double toInches(double value) { return value * 36; }
        @Override
        public double toFeet(double value) { return value * 3; }
        @Override
        public double toYards(double value) { return value; }
        @Override
        public double toMiles(double value) { return value / 1760; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toYards(value);
        }
    },
    MILES {
        @Override
        public double toMillimeters(double value) { return value * 1.609  * 10e6; }
        @Override
        public double toCentimeters(double value) { return value * 1.609  * 10e5; }
        @Override
        public double toMeters(double value) { return value * 1.609  * 10e3; }
        @Override
        public double toKilometers(double value) { return value * 1.609; }
        @Override
        public double toInches(double value) { return value / 6.3 * 10e-4; }
        @Override
        public double toFeet(double value) { return value * 5280; }
        @Override
        public double toYards(double value) { return value * 1760; }
        @Override
        public double toMiles(double value) { return value; }

        @Override
        public double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toMiles(value);
        }
    };
    
    public abstract double toMillimeters(double value);
    public abstract double toCentimeters(double value);
    public abstract double toMeters(double value);
    public abstract double toKilometers(double value);
    public abstract double toInches(double value);
    public abstract double toFeet(double value);
    public abstract double toYards(double value);
    public abstract double toMiles(double value);

    public abstract double convertFrom(double value, DistanceUnit fromUnit);
}

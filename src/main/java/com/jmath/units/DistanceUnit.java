package com.jmath.units;

public enum DistanceUnit {
    MM {
        @Override
        double toMillimeters(double value) { return value; }
        @Override
        double toCentimeters(double value) { return value * 0.1; }
        @Override
        double toMeters(double value) { return value * 10e-3; }
        @Override
        double toKilometers(double value) { return value * 10e-6; }
        @Override
        double toInches(double value) { return value / 25.4; }
        @Override
        double toFeet(double value) { return value / 304.8; }
        @Override
        double toYards(double value) { return value / 914.4; }
        @Override
        double toMiles(double value) { return value / 1.609 * 10e-6; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toMillimeters(value);
        }
    },
    CM {
        @Override
        double toMillimeters(double value) { return value * 10; }
        @Override
        double toCentimeters(double value) { return value; }
        @Override
        double toMeters(double value) { return value * 10e-2; }
        @Override
        double toKilometers(double value) { return value * 10e-5; }
        @Override
        double toInches(double value) { return value / 2.54; }
        @Override
        double toFeet(double value) { return value / 30.48; }
        @Override
        double toYards(double value) { return value / 91.44; }
        @Override
        double toMiles(double value) { return value / 1.609 * 10e-5; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toCentimeters(value);
        }
    },
    METERS {
        @Override
        double toMillimeters(double value) { return value * 10e3; }
        @Override
        double toCentimeters(double value) { return value * 100; }
        @Override
        double toMeters(double value) { return value; }
        @Override
        double toKilometers(double value) { return value * 10e-3; }
        @Override
        double toInches(double value) { return value * 39.37; }
        @Override
        double toFeet(double value) { return value * 3.281; }
        @Override
        double toYards(double value) { return value * 1.094; }
        @Override
        double toMiles(double value) { return value / 1.609 * 10e-3; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toMeters(value);
        }
    },
    KM {
        @Override
        double toMillimeters(double value) { return value * 10e6; }
        @Override
        double toCentimeters(double value) { return value * 10e4; }
        @Override
        double toMeters(double value) { return value * 10e3; }
        @Override
        double toKilometers(double value) { return value; }
        @Override
        double toInches(double value) { return value * 3.937 * 10e4; }
        @Override
        double toFeet(double value) { return value * 3.28 * 10e3; }
        @Override
        double toYards(double value) { return value * 1.093 * 10e3; }
        @Override
        double toMiles(double value) { return value / 1.609; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toKilometers(value);
        }
    },
    INCHES {
        @Override
        double toMillimeters(double value) { return value * 25.4; }
        @Override
        double toCentimeters(double value) { return value * 2.54; }
        @Override
        double toMeters(double value) { return value / 39.37; }
        @Override
        double toKilometers(double value) { return value / 3.937 * 10e-4; }
        @Override
        double toInches(double value) { return value; }
        @Override
        double toFeet(double value) { return value / 12; }
        @Override
        double toYards(double value) { return value / 36; }
        @Override
        double toMiles(double value) { return value / 6.3 * 10e-4; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toInches(value);
        }
    },
    FEET {
        @Override
        double toMillimeters(double value) { return value * 304.8; }
        @Override
        double toCentimeters(double value) { return value * 30.48; }
        @Override
        double toMeters(double value) { return value / 3.281; }
        @Override
        double toKilometers(double value) { return value / 3.28 * 10e-3; }
        @Override
        double toInches(double value) { return value * 12; }
        @Override
        double toFeet(double value) { return value; }
        @Override
        double toYards(double value) { return value / 3; }
        @Override
        double toMiles(double value) { return value / 5280; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toFeet(value);
        }
    },
    YARDS {
        @Override
        double toMillimeters(double value) { return value * 914.4; }
        @Override
        double toCentimeters(double value) { return value * 91.44; }
        @Override
        double toMeters(double value) { return value / 1.094; }
        @Override
        double toKilometers(double value) { return value / 1.093 * 10e-3; }
        @Override
        double toInches(double value) { return value * 36; }
        @Override
        double toFeet(double value) { return value * 3; }
        @Override
        double toYards(double value) { return value; }
        @Override
        double toMiles(double value) { return value / 1760; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toYards(value);
        }
    },
    MILES {
        @Override
        double toMillimeters(double value) { return value * 1.609  * 10e6; }
        @Override
        double toCentimeters(double value) { return value * 1.609  * 10e5; }
        @Override
        double toMeters(double value) { return value * 1.609  * 10e3; }
        @Override
        double toKilometers(double value) { return value * 1.609; }
        @Override
        double toInches(double value) { return value / 6.3 * 10e-4; }
        @Override
        double toFeet(double value) { return value * 5280; }
        @Override
        double toYards(double value) { return value * 1760; }
        @Override
        double toMiles(double value) { return value; }

        @Override
        double convertFrom(double value, DistanceUnit fromUnit) {
            return fromUnit.toMiles(value);
        }
    };
    
    abstract double toMillimeters(double value);
    abstract double toCentimeters(double value);
    abstract double toMeters(double value);
    abstract double toKilometers(double value);
    abstract double toInches(double value);
    abstract double toFeet(double value);
    abstract double toYards(double value);
    abstract double toMiles(double value);

    abstract double convertFrom(double value, DistanceUnit fromUnit);
}

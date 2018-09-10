package com.jmath.complex;

import java.util.Objects;

public class Complex {

    private final double mReal;
    private final double mImaginary;

    public Complex(double real, double imaginary) {
        mReal = real;
        mImaginary = imaginary;
    }

    public static Complex eularRadians(double magnitude, double angle) {
        double real = magnitude * Math.cos(angle);
        double imaginary = magnitude * Math.sin(angle);

        return new Complex(real, imaginary);
    }

    public static Complex eular(double magnitude, double angle) {
        return eularRadians(magnitude, Math.toRadians(angle));
    }

    public double real() {
        return mReal;
    }

    public double imaginary() {
        return mImaginary;
    }

    public double magnitude() {
        return Math.sqrt(mReal * mReal + mImaginary * mImaginary);
    }

    public double angleRadians() {
        return Math.atan2(mReal, mImaginary);
    }

    public double angle() {
        return Math.toDegrees(angleRadians());
    }

    public double max() {
        return Math.max(mReal, mImaginary);
    }

    public double min() {
        return Math.min(mReal, mImaginary);
    }

    public double sum() {
        return mReal + mImaginary;
    }

    public Complex abs() {
        return new Complex(Math.abs(mReal), Math.abs(mImaginary));
    }

    public Complex singular() {
        return new Complex(Math.signum(mReal), Math.signum(mImaginary));
    }

    public Complex normalized() {
        double magnitude = magnitude();
        return new Complex(mReal / magnitude, mImaginary / magnitude);
    }

    public Complex copy() {
        return new Complex(mReal, mImaginary);
    }

    public Complex conjugate() {
        return new Complex(mReal, -mImaginary);
    }

    public Complex add(double scalar) {
        return new Complex(mReal + scalar, mImaginary + scalar);
    }

    public Complex add(Complex complex) {
        return new Complex(mReal + complex.mReal, mImaginary + complex.mImaginary);
    }

    public Complex sub(double scalar) {
        return new Complex(mReal - scalar, mImaginary - scalar);
    }

    public Complex sub(Complex complex) {
        return new Complex(mReal - complex.mReal, mImaginary - complex.mImaginary);
    }

    public Complex multiply(double scalar) {
        return new Complex(mReal * scalar, mImaginary * scalar);
    }

    public Complex multiply(Complex complex) {
        return new Complex(mReal * complex.mReal - mImaginary * complex.mImaginary, mReal * complex.mImaginary + mImaginary * complex.mReal);
    }

    public Complex div(double scalar) {
        return new Complex(mReal / scalar, mImaginary / scalar);
    }

    public Complex div(Complex complex) {
        if (complex.mImaginary == 0) {
            return div(complex.mReal);
        }

        Complex conjugate = complex.conjugate();
        return multiply(conjugate).div(complex.multiply(conjugate));
    }

    public boolean equals(Complex other) {
        return other != null && mReal == other.mReal && mImaginary == other.mImaginary;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Complex && equals((Complex)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mReal, mImaginary);
    }

    @Override
    public String toString() {
        return String.format("(%f %s %fi)", mReal, mImaginary < 0.0 ? "-" : "+", Math.abs(mImaginary));
    }
}

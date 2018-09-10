package com.jmath.vectors;

import java.util.Objects;

public class Vector2 {

    private final double mX;
    private final double mY;

    public Vector2(double x, double y) {
        mX = x;
        mY = y;
    }

    public Vector2() {
        this(0.0, 0.0);
    }

    public static Vector2 polar(double magnitude, double angle) {
        double x = magnitude * Math.cos(Math.toRadians(angle));
        double y = magnitude * Math.sin(Math.toRadians(angle));
        return new Vector2(x, y);
    }

    public double x() {
        return mX;
    }

    public double y() {
        return mY;
    }

    public double magnitude() {
        return Math.sqrt(mX * mX + mY * mY);
    }

    public double angleRadians() {
        return Math.atan2(mX, mY);
    }

    public double angle() {
        return Math.toDegrees(angleRadians());
    }

    public double max() {
        return Math.max(mX, mY);
    }

    public double min() {
        return Math.min(mX, mY);
    }

    public Vector2 normalized() {
        double magnitude = magnitude();
        return new Vector2(mX / magnitude, mY / magnitude);
    }

    public Vector2 add(double scalar) {
        return new Vector2(mX + scalar, mY + scalar);
    }

    public Vector2 add(Vector2 vector) {
        return new Vector2(mX + vector.mX, mY + vector.mY);
    }

    public Vector2 sub(double scalar) {
        return new Vector2(mX - scalar, mY - scalar);
    }

    public Vector2 sub(Vector2 vector) {
        return new Vector2(mX - vector.mX, mY - vector.mY);
    }

    public Vector2 multiply(double scalar) {
        return new Vector2(mX * scalar, mY * scalar);
    }

    public Vector2 multiply(Vector2 vector) {
        return new Vector2(mX * vector.mX, mY * vector.mY);
    }

    public Vector2 div(double scalar) {
        return new Vector2(mX / scalar, mY / scalar);
    }

    public Vector2 div(Vector2 vector) {
        return new Vector2(mX / vector.mX, mY / vector.mY);
    }

    public double dot(Vector2 vector) {
        return mX * vector.mX + mY * vector.mY;
    }

    public double cross(Vector2 vector) {
        return mX * vector.mX - mY * vector.mY;
    }

    public double angleTo(Vector2 vector) {
        return Math.acos(dot(vector) / (magnitude() + vector.magnitude()));
    }

    public boolean equals(Vector2 other) {
        return mX == other.mX && mY == other.mY;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vector2 && equals((Vector2)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mX, mY);
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", mX, mY);
    }
}

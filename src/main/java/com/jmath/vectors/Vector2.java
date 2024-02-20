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

    public static Vector2 polarRadians(double magnitude, double angle) {
        double x = magnitude * Math.cos(angle);
        double y = magnitude * Math.sin(angle);
        return new Vector2(x, y);
    }

    public static Vector2 polar(double magnitude, double angle) {
        return polarRadians(magnitude, Math.toRadians(angle));
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

    public double sum() {
        return mX + mY;
    }

    public Vector2 abs() {
        return new Vector2(Math.abs(mX), Math.abs(mY));
    }

    public Vector2 singular() {
        return new Vector2(Math.signum(mX), Math.signum(mY));
    }

    public Vector2 normalized() {
        double magnitude = magnitude();
        return new Vector2(mX / magnitude, mY / magnitude);
    }

    public Vector2 copy() {
        return new Vector2(mX, mY);
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
        return Math.acos(dot(vector) / (magnitude() * vector.magnitude()));
    }

    public Vector2 rotateRadians(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        return new Vector2(
                mX * cos - mY * sin,
                mX * sin + mY * cos);
    }

    public Vector2 rotate(double angle) {
        return rotateRadians(Math.toRadians(angle));
    }

    public boolean equals(Vector2 other) {
        return other != null && mX == other.mX && mY == other.mY;
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

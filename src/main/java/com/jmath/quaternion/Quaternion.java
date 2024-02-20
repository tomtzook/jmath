package com.jmath.quaternion;

import com.jmath.vectors.Vector3;

import java.util.Objects;

public class Quaternion {

    public enum Pole {
        NORTH {
            @Override
            public double getYaw(Quaternion quaternion) {
                return 0;
            }

            @Override
            public double getRoll(Quaternion quaternion) {
                return 2 * Math.atan2(quaternion.mX, quaternion.mW);
            }

            @Override
            public double getPitch(Quaternion quaternion) {
                return Math.PI * 0.5;
            }
        },
        SOUTH {
            @Override
            public double getYaw(Quaternion quaternion) {
                return 0;
            }

            @Override
            public double getRoll(Quaternion quaternion) {
                return -2 * Math.atan2(quaternion.mX, quaternion.mW);
            }

            @Override
            public double getPitch(Quaternion quaternion) {
                return -Math.PI * 0.5;
            }
        },
        NONE {
            @Override
            public double getYaw(Quaternion quaternion) {
                return Math.atan2(
                        2 * quaternion.mX * quaternion.mW - 2 * quaternion.mY * quaternion.mZ,
                        -Math.sqrt(quaternion.mX * quaternion.mX) + Math.sqrt(quaternion.mY * quaternion.mY)
                                -Math.sqrt(quaternion.mZ * quaternion.mZ) + Math.sqrt(quaternion.mW * quaternion.mW)
                );
            }

            @Override
            public double getRoll(Quaternion quaternion) {
                return Math.atan2(
                        2 * quaternion.mY * quaternion.mW - 2 * quaternion.mX * quaternion.mZ,
                        Math.sqrt(quaternion.mX * quaternion.mX) - Math.sqrt(quaternion.mY * quaternion.mY)
                                -Math.sqrt(quaternion.mZ * quaternion.mZ) + Math.sqrt(quaternion.mW * quaternion.mW)
                );
            }

            @Override
            public double getPitch(Quaternion quaternion) {
                return Math.asin(2 *
                        (quaternion.mX * quaternion.mY + quaternion.mZ * quaternion.mW) /
                        quaternion.magnitude());
            }
        }
        ;

        public abstract double getYaw(Quaternion quaternion);
        public abstract double getRoll(Quaternion quaternion);
        public abstract double getPitch(Quaternion quaternion);
    }

    private final double mX;
    private final double mY;
    private final double mZ;
    private final double mW;

    public Quaternion(double x, double y, double z, double w) {
        mX = x;
        mY = y;
        mZ = z;
        mW = w;
    }

    public Quaternion() {
        this(0.0, 0.0, 0.0, 0.0);
    }

    public static Quaternion fromAnglesRadians(double x, double y, double z) {
        double angle = z * 0.5f;
        double sinZ = Math.sin(angle);
        double cosZ = Math.cos(angle);
        angle = y * 0.5f;
        double sinY = Math.sin(angle);
        double cosY = Math.cos(angle);
        angle = x * 0.5f;
        double sinX = Math.sin(angle);
        double cosX = Math.cos(angle);

        double cosYXcosZ = cosY * cosZ;
        double sinYXsinZ = sinY * sinZ;
        double cosYXsinZ = cosY * sinZ;
        double sinYXcosZ = sinY * cosZ;

        return new Quaternion(
                (cosYXcosZ * sinX + sinYXsinZ * cosX),
                (sinYXcosZ * cosX + cosYXsinZ * sinX),
                (cosYXsinZ * cosX - sinYXcosZ * sinX),
                (cosYXcosZ * cosX - sinYXsinZ * sinX)).normalized();
    }

    public static Quaternion fromAngles(double x, double y, double z) {
        return fromAnglesRadians(Math.toRadians(x), Math.toRadians(y),
                Math.toRadians(z));
    }

    public static Quaternion rotationOnAxisRadians(Vector3 axis, double angle) {
        double sinHalfAngle = Math.sin(angle / 2);
        double cosHalfAngle = Math.cos(angle / 2);

        return new Quaternion(
                axis.x() * sinHalfAngle,
                axis.y() * sinHalfAngle,
                axis.z() * sinHalfAngle,
                cosHalfAngle);
    }

    public static Quaternion rotationOnAxis(Vector3 axis, double angle) {
        return rotationOnAxisRadians(axis, Math.toRadians(angle));
    }

    public double x() {
        return mX;
    }

    public double y() {
        return mY;
    }

    public double z() {
        return mZ;
    }

    public double w() {
        return mW;
    }

    public Pole getPole() {
        double length = magnitude();
        double test = mX * mY + mZ * mW;

        if (test > 0.499 * length) {
            return Pole.NORTH;
        } else if (test < -0.499 * length) {
            return Pole.SOUTH;
        }

        return Pole.NONE;
    }

    public double getYawRadians() {
        return getPole().getYaw(this);
    }

    public double getYaw() {
        return Math.toDegrees(getYawRadians());
    }

    public double getRollRadians() {
        return getPole().getRoll(this);
    }

    public double getRoll() {
        return Math.toDegrees(getRollRadians());
    }

    public double getPitchRadians() {
        return getPole().getPitch(this);
    }

    public double getPitch() {
        return Math.toDegrees(getPitchRadians());
    }

    public double magnitude() {
        return Math.sqrt(mX * mX + mY * mY + mZ * mZ + mW * mW);
    }

    public Quaternion normalized(){
        double length = magnitude();
        return new Quaternion(mX / length, mY / length, mZ / length, mW / length);
    }

    public Quaternion copy() {
        return new Quaternion(mX, mY, mZ, mW);
    }

    public Quaternion conjugate() {
        return new Quaternion(-mX, -mY, -mZ, mW);
    }

    public Quaternion add(Quaternion quaternion) {
        return new Quaternion(mX + quaternion.mX, mY + quaternion.mY, mZ + quaternion.mZ, mW + quaternion.mW);
    }

    public Quaternion add(float scalar) {
        return new Quaternion(mX + scalar, mY + scalar, mZ + scalar, mW + scalar);
    }

    public Quaternion sub(Quaternion quaternion) {
        return new Quaternion(mX - quaternion.mX, mY - quaternion.mY, mZ - quaternion.mZ, mW - quaternion.mW);
    }

    public Quaternion sub(float scalar) {
        return new Quaternion(mX - scalar, mY - scalar, mZ - scalar, mW - scalar);
    }

    public Quaternion multiply(float scalar) {
        return new Quaternion(mX * scalar, mY * scalar, mZ * scalar, mW * scalar);
    }

    public Quaternion multiply(Quaternion quaternion){
        double w_ = mW * quaternion.mW - mX * quaternion.mX - mY * quaternion.mY - mZ * quaternion.mZ;
        double x_ = mX * quaternion.mW + mW * quaternion.mX + mY * quaternion.mZ - mZ * quaternion.mY;
        double y_ = mY * quaternion.mW + mW * quaternion.mY + mZ * quaternion.mX - mX * quaternion.mZ;
        double z_ = mZ * quaternion.mW + mW * quaternion.mZ + mX * quaternion.mY - mY * quaternion.mX;

        return new Quaternion(x_, y_, z_, w_);
    }

    public Quaternion multiply(Vector3 vector){
        double w_ = -mX * vector.x() - mY * vector.y() - mZ * vector.z();
        double x_ =  mW * vector.x() + mY * vector.z() - mZ * vector.y();
        double y_ =  mW * vector.y() + mZ * vector.x() - mX * vector.z();
        double z_ =  mW * vector.z() + mX * vector.y() - mY * vector.x();

        return new Quaternion(x_, y_, z_, w_);
    }

    public double dot(Quaternion quaternion){
        return mX * quaternion.mX + mY * quaternion.mY + mZ * quaternion.mZ + mW * quaternion.mW;
    }

    public Vector3 forward(){
        Vector3 vector = new Vector3(0.0, 0.0, 1.0);
        return vector.rotate(this);
    }

    public Vector3 back(){
        Vector3 vector = new Vector3(0.0, 0.0, -1.0);
        return vector.rotate(this);
    }

    public Vector3 up(){
        Vector3 vector = new Vector3(0.0, 1.0, 0.0);
        return vector.rotate(this);
    }

    public Vector3 down(){
        Vector3 vector = new Vector3(0.0,-1.0, 0.0);
        return vector.rotate(this);
    }

    public Vector3 right(){
        Vector3 vector = new Vector3(1.0, 0.0, 0.0);
        return vector.rotate(this);
    }

    public Vector3 left(){
        Vector3 vector = new Vector3(-1.0, 0.0, 0.0);
        return vector.rotate(this);
    }

    public boolean equals(Quaternion other) {
        return other != null && mX == other.mX && mY == other.mY && mZ == other.mZ
                && mW == other.mW;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Quaternion && equals((Quaternion)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mX, mY, mZ, mW);
    }

    @Override
    public String toString() {
        return String.format("(%.3f, %.3f, %.3f, %.3f)", mX, mY, mZ, mW);
    }
}

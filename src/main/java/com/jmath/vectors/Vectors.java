package com.jmath.vectors;

public class Vectors {

    private Vectors() {}

    public static Vector2 cartesian(double x, double y) {
        return new Vector2(x, y);
    }

    public static Vector2 polar(double magnitude, double angle) {
        return Vector2.polar(magnitude, angle);
    }

    public static Vector2 polarRadians(double magnitude, double angle) {
        return Vector2.polarRadians(magnitude, angle);
    }

    public static Vector3 cartesian(double x, double y, double z) {
        return new Vector3(x, y, z);
    }

    public static Vector3 polar(double magnitude, double azimuth, double inclination) {
        return Vector3.polar(magnitude, azimuth, inclination);
    }

    public static Vector3 polarRadians(double magnitude, double azimuth, double inclination) {
        return Vector3.polarRadians(magnitude, azimuth, inclination);
    }
}

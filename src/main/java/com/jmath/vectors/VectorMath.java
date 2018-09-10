package com.jmath.vectors;

public class VectorMath {

    private VectorMath() {}

    public static Vector2 net(Vector2... vectors) {
        double x = 0;
        double y = 0;

        for (Vector2 vector : vectors) {
            x += vector.x();
            y += vector.y();
        }

        return new Vector2(x, y);
    }

    public static Vector3 net(Vector3... vectors) {
        double x = 0;
        double y = 0;
        double z = 0;

        for (Vector3 vector : vectors) {
            x += vector.x();
            y += vector.y();
            z += vector.z();
        }

        return new Vector3(x, y, z);
    }
}

package com.jmath.matrices;

public class Matrices {

    private Matrices() {}

    public static Matrix translation2d(double x, double y) {
        double[][] mat = new double[][]{
                {1,0,x},
                {0,1,y},
                {0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix translation3d(double x, double y, double z) {
        double[][] mat =  new double[][]{
                {1,0,0,x},
                {0,1,0,y},
                {0,0,1,z},
                {0,0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix rotation2dRadians(double angle) {
        double[][] mat = new double[][]{
                {Math.cos(angle), -Math.sin(angle), 0},
                {Math.sin(angle), Math.cos(angle), 0},
                {0, 0, 1},
        };

        return new Matrix(mat);
    }

    public static Matrix rotation2d(double angle) {
        return rotation2dRadians(Math.toRadians(angle));
    }

    public static Matrix rotation3dAxisXRadians(double angle) {
        double[][] mat = new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(angle), -Math.sin(angle), 0},
                {0, Math.sin(angle), Math.cos(angle), 0},
                {0,0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix rotation3dAxisX(double angle) {
        return rotation3dAxisXRadians(Math.toRadians(angle));
    }

    public static Matrix rotation3dAxisYRadians(double angle) {
        double[][] mat = new double[][]{
                {Math.cos(angle), 0, Math.sin(angle),0},
                {0, 1, 0,0},
                {-Math.sin(angle), 0, Math.cos(angle),0},
                {0,0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix rotation3dAxisY(double angle) {
        return rotation3dAxisYRadians(Math.toRadians(angle));
    }

    public static Matrix rotation3dAxisZRadians(double angle) {
        double[][] mat =  new double[][]{
                {Math.cos(angle), -Math.sin(angle), 0,0},
                {Math.sin(angle), Math.cos(angle), 0,0},
                {0,0,1,0},
                {0,0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix rotation3dAxisZ(double angle) {
        return rotation3dAxisZRadians(Math.toRadians(angle));
    }

    public static Matrix rotation3dRadians(double xAngle, double yAngle, double zAngle) {
        Matrix xMatrix = rotation3dAxisXRadians(xAngle);
        Matrix yMatrix = rotation3dAxisYRadians(yAngle);
        Matrix zMatrix = rotation3dAxisZRadians(zAngle);

        return xMatrix.multiply(yMatrix).multiply(zMatrix);
    }

    public static Matrix rotation3d(double xAngle, double yAngle, double zAngle) {
        return rotation3dRadians(Math.toRadians(xAngle), Math.toRadians(yAngle), Math.toRadians(zAngle));
    }

    public static Matrix identity2d() {
        double[][] mat = new double[][] {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix identity3d() {
        double[][] mat = new double[][] {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix scaling2d(double x, double y) {
        double[][] mat = new double[][]{
                {x,0,0},
                {0,y,0},
                {0,0,1}
        };

        return new Matrix(mat);
    }

    public static Matrix scaling3d(double x, double y, double z) {
        double[][] mat = new double[][]{
                {x,0,0,0},
                {0,y,0,0},
                {0,0,z,0},
                {0,0,0,1}
        };

        return new Matrix(mat);
    }
}

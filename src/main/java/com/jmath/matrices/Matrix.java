package com.jmath.matrices;

import java.util.Arrays;

public class Matrix {

    private final double[][] mMat;

    public Matrix(int rows, int cols) {
        mMat = new double[rows][cols];
    }

    Matrix(double[][] mat) {
        mMat = mat;
    }

    public static Matrix from(double[][] mat) {
        return new Matrix(copyMat(mat));
    }

    public int rows() {
        return mMat.length;
    }

    public int cols() {
        if (rows() < 1) {
            return 0;
        }

        return mMat[0].length;
    }

    public double get(int row, int col) {
        return mMat[row][col];
    }

    public double[] row(int row) {
        return Arrays.copyOf(mMat[row], cols());
    }

    public double[] col(int col) {
        double[] result = new double[rows()];
        for (int i = 0; i < result.length; i++) {
            result[i] = mMat[i][col];
        }

        return result;
    }

    public double[][] mat() {
        return copyMat(mMat);
    }

    public Matrix reversed() {
        double[][] values = mat();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                values[i][j] *= -1;
            }
        }

        return new Matrix(values);
    }

    public Matrix multiply(Matrix matrix) {
        if(cols() != matrix.rows()) {
            throw new IllegalArgumentException("Cannot multiply matricies: cols != other.rows");
        }

        double[][] result = new double[rows()][matrix.cols()];
        for(int i = 0; i < result[0].length; i++){
            for(int j = 0; j < result.length; j++){
                double value = 0;
                for(int k = 0; k < result.length; k++) {
                    value += mMat[j][k] * matrix.mMat[k][i];
                }
                result[j][i] = value;
            }
        }

        return new Matrix(result);
    }

    private static double[][] copyMat(double[][] mat) {
        double[][] values = new double[mat.length][mat[0].length];
        for (int i = 0; i < values.length; i++) {
            System.arraycopy(mat[i], 0, values[i], 0, mat[0].length);
        }

        return values;
    }
}

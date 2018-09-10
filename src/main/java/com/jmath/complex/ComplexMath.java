package com.jmath.complex;

import com.jmath.Mathx;

public class ComplexMath {

    private ComplexMath() {}

    public static Complex complexRoot(double radicand, int degree) {
        if (radicand > 0) {
            return new Complex(Mathx.root(radicand, degree), 0);
        }
        if (radicand == 0) {
            return new Complex();
        }

        double result = Mathx.root(-radicand, degree);
        return new Complex(0.0, result);
    }

    public static Complex divideByComplex(double numerator, Complex denumerator) {
        final Complex I = new Complex(0.0, 1.0);
        return new Complex(0.0, numerator).div(denumerator.multiply(I));
    }
}

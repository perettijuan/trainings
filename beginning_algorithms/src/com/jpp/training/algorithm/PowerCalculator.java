package com.jpp.training.algorithm;

public class PowerCalculator {


    public static int calculate(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("exponent can not be null");
        }
        int result = 1;
        for(int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

}

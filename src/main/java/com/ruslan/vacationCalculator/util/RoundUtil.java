package com.ruslan.vacationCalculator.util;

public class RoundUtil {

    public static double round(double value) {
        return  Math.round(value * 100) / 100.0;
    }
}

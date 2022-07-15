package com.coding.utils;

public class ServiceUtils {

    public static String[] getDefaultRandomNumbers(int min, int max) {
        int number = (int) (Math.random() * (max - min + 1) + min);
        String str = String.valueOf(number);
        return str.split("");
    }
}

package com.orange.utils;

import java.util.Random;

public class GenerateId {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase();
    private static final String DIGITS = "0123456789";
    private static final String ALL_CHARS = UPPER + LOWER + DIGITS;
    private static final Random RANDOM = new Random();

    public static String generateSerial(int length) {
        StringBuilder serial = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALL_CHARS.length());
            serial.append(ALL_CHARS.charAt(index));
        }
        return serial.toString();
    }

    public static void main(String[] args) {
        System.out.println("Serial generado: " + generateSerial(5));
    }
}



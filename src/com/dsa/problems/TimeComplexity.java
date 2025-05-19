package com.dsa.problems;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeComplexity {

    public static void main(String[] args) {
        LocalDateTime starTime = LocalDateTime.now();
        testTimeComplexity();
        LocalDateTime endTime = LocalDateTime.now();

        // Everytime the program is run the time taken to complete varies.
        // In such case cannot take this as a standard fixed number.
        // So industry uses Big-O notation.
        Duration d = Duration.between(starTime, endTime);
        System.out.println(d.toMillis());
    }

    static void testTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
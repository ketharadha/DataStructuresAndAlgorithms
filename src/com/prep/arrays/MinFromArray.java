package com.prep.arrays;

import com.prep.util.Printer;

public class MinFromArray {

    public static void main(String[] args) {
        MinFromArray minFromArray = new MinFromArray();
        Printer printer = new Printer();
        final int[] inputArray = {12,11,5,10,7,0,8,1};
        //final int[] inputArray = null;
        final int minElement = minFromArray.findMinFromArray(inputArray);
        printer.printInt(minElement);
    }

    private int findMinFromArray(int[] inputArray) {
        //edge cases
        if (inputArray.length < 2) {
            throw new IllegalArgumentException("Invalid input.");
        }
        int minElement = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if(inputArray[i] < minElement) {
                minElement = inputArray[i];
            }
        }
        return minElement;
    }
}

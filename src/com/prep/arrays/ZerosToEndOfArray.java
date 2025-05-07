package com.prep.arrays;

import com.prep.util.Printer;

//Before the interview
public class ZerosToEndOfArray {

    private int[] moveZerosToEndOfArray(int[] inputArray) {
        int pivot = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != 0 && inputArray[pivot] == 0) {
                int temp = inputArray[i];
                inputArray[i] = inputArray[pivot];
                inputArray[pivot] = temp;
            }
            if (inputArray[pivot] != 0) {
                pivot++;
            }        
        }
        return inputArray;
    }

    public static void main(String[] args) {
        ZerosToEndOfArray zerosToEndOfArray = new ZerosToEndOfArray();
        int[] inputArray = {23, 0, 4, 0, 9, 34, 34};
        int[] updateArray = zerosToEndOfArray.moveZerosToEndOfArray(inputArray);
        Printer printer = new Printer();
        printer.printArrays(updateArray);
    }
}

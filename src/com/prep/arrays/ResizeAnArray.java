package com.prep.arrays;

import com.prep.util.Printer;

public class ResizeAnArray {
    
    public static void main(String[] args) {
        ResizeAnArray resizeAnArray = new ResizeAnArray();
        int[] array = {4,3,2,7,1};
        int capacity = 9;
        int[] resizedArray = resizeAnArray.getReSizedArray(array, capacity);
        Printer printer = new Printer();
        printer.printInt(array.length);
        printer.printArrays(resizedArray);
        printer.printInt(resizedArray.length);
    }

    private int[] getReSizedArray(int[] array, int capacity) {
        int[] tempArray = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        return tempArray;
    }
}

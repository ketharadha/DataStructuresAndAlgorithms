package com.prep.arrays;

public class ReverseArray {

    private void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + ",");
        }
    }

    private int[] reverIntArray(int[] intArray) {
        int[] reverseArray = new int[intArray.length];

        for (int i = reverseArray.length; i > 0; i--) {
            reverseArray[reverseArray.length - i] = intArray[i-1];
        }

        return reverseArray;
    }


    private int[] reverArray(int[] arr) {
        int[] revArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            revArr[i] = arr[arr.length - (i + 1)];
        }
        return revArr;
    }

    private int[] reverArrayBySwapMethod(int[] intArray) {
        int start = 0;
        int end = intArray.length-1;
        while (start < end) {
            int temp = intArray[end];
            intArray[end] = intArray[start];
            intArray[start] = temp;
            start ++;
            end --;
        }
        return intArray;
    }
    
    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        /*int inputArray[] = {2,11,5,10,7,8};
        reverseArray.printArray(inputArray);
        int[] reverIntArray = reverseArray.reverIntArray(inputArray);
        System.out.println("\n");
        reverseArray.printArray(reverIntArray);
        System.out.println("\n");
        int[] reverArrayBySwapMethod = reverseArray.reverArrayBySwapMethod(inputArray);
        reverseArray.printArray(reverArrayBySwapMethod);*/
        int input[] = {1,4,3,2,6,5};
        reverseArray.printArray(reverseArray.reverArray(input));
    }
}

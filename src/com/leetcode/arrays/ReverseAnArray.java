package com.leetcode.arrays;

public class ReverseAnArray {
    
    //O(n)
    private int[] reverseIntArray(int[] input) {
        if(input.length == 0) {
            System.out.println("Array has not elements to ");
        }
        int[] revArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            revArray[i] = input[input.length - 1 -i];
        }
        return revArray;
    }

    //Two Pointer and O(1)
    private int[] reverseIntegerArray(int[] input) {
        //validate for null check and throw illegalArgumetn exception
        if (input == null) {
            throw new IllegalArgumentException("Input array should not be null");
        }

        //If length of the array is 0 then return an info message
        if(input.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Inout array should have atleast one element");
        }
        
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }

        return input;
    }

    private void print(int[] printArray) {
        for (int printElement : printArray) {
            System.out.print(printElement + " ");
        }
    }


    public static void main(String[] args) {
        ReverseAnArray revArray = new ReverseAnArray();
        //revArray.print(revArray.reverseIntArray(new int[] {6,4,3,6,7,1,2}));

        int[] input = null;
        try {
            revArray.print(revArray.reverseIntegerArray(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        input = new int[]{};
        try {
            revArray.print(revArray.reverseIntegerArray(input));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        input = new int[]{7,2,6,2,7,1,8,9};
        revArray.print(revArray.reverseIntegerArray(input));
    }
}

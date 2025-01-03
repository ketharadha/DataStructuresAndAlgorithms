package com.prep.arrays;

public class FindMissingNumber {

    public static void main(String[] args) {
        FindMissingNumber findMissingNumber = new FindMissingNumber();
        int[] arrayNum = {2,4,1,5,6,3,7,9};
        int number = findMissingNumber.findMissingNumber(arrayNum);
        System.out.println("missing Number : " + number);
    }

    private int findMissingNumber(int[] arrayNum) {
        int arrSize = arrayNum.length + 1;
        int expectedSum = (arrSize * (arrSize + 1)) / 2;
        for (int i = 0; i < arrayNum.length; i++) {
            expectedSum = expectedSum - arrayNum[i];
        }
        return expectedSum;
    }
}

package com.prep.arrays;

public class RemoveEvenIntegerArray {

    private int[] removeEvenNumbersFromIntArray(final int[] intArray) {
        int oddCounter = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (!isEvenNumber(intArray[i])) {
                oddCounter++;
            }
        }
        System.out.println("Odd Counter Size : " + oddCounter);
        int[] oddNumberArray = new int[oddCounter];
        int oddNumberArrayidx = 0;
        for (int i = 0; i < intArray.length; i++) {
            if(!isEvenNumber(intArray[i])) {
                oddNumberArray[oddNumberArrayidx]= intArray[i];
                oddNumberArrayidx++;
            }
        }
        
        return oddNumberArray;
    }

    private boolean isEvenNumber( int number) {
       return (number % 2 == 0) ? true : false;
    }

    private void printIntArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + ",");
        }
    }

    public static void main(final String[] args) {
        RemoveEvenIntegerArray removeEvenIntegerArray = new RemoveEvenIntegerArray();
        int[] intArray = {5,2,3,1,2,4,6,8};
        removeEvenIntegerArray.printIntArray(intArray);
        int[] oddArray = removeEvenIntegerArray.removeEvenNumbersFromIntArray(intArray);
        removeEvenIntegerArray.printIntArray(oddArray);
    }
}

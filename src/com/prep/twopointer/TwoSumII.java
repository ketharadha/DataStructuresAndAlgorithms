package com.prep.twopointer;

import java.util.Arrays;

/**
 * Given an array of integers, return indices(1-indexed) of the two numbers such that they add up to a specific target.
 */
public class TwoSumII {

    public static void main(String[] args) {
        int[] inputArray = {4,6,9,15,25}; //sorted Array
        int target = 90;
        System.out.println(Arrays.toString(TwoSumII.twoSumIndicesUsingFor(inputArray, target)));
        
    }
    
    /**
     * Key take aways, 
     * 1. -> Loop should exit when i < j. Because, when i > j, that mean both i and j crossed their paths 
     * and the sum of the elements will be calculated again which is of no use.
     * -> Incrementing i and decrementing j are done outside for loop because they need to be updated based on certain condition. 
     * -> Better to go with while loop for clean code.
     * 2. If sum is equal to target, return both indexes in the form of an array. 
     *    Before that increment both the indexes by one to make them 1-indexed.
     * 3. If sum is greater than target then, that mean right pointer is moved left to access the lesser value than previous.
     * 4. if sum is less than target then, left pointer is moved right to access a bigger value than the previous.
     * @param inputArray
     * @param target
     * @return int[] of indexes of the two numbers such that they add up to a specific target.
     */

    public static int[] twoSumIndices(int[] inputArray, int target) {
        int i = 0;
        int j = inputArray.length-1;
        while( i < j) { // As the array is sorted if i and j crosses each other, then we will be calculating the same sum again which is of no use.
            int twoSum = inputArray[i] + inputArray[j];
            System.out.println(inputArray[i] +" + "+ inputArray[j] + " = " + twoSum);
            if (twoSum == target) {
                return new int[] {i+1, j+1}; // "+1" is to have 1-indexed output.
            } else if(twoSum > target) { // In this case, to get the sum equal to target, j has to move to it's left by decremetning.
                j--;
            } else { // Because the array is sorted, to get the sum equal to target i had to move right by incrementing.
                i++;
            }
        }
        return new int[]{-1, -1}; // If no target is found.
    }

    public static int[] twoSumIndicesUsingFor(int[] inputArray, int target) {
        // As the array is sorted if i and j crosses each other, then we will be calculating the same sum again which is of no use.
        // So, the loop should exit when i < j. 
        // Incrementing i and decrementing j are done outside for loop because they need to be updated based on certain condition.
        for(int i = 0, j = inputArray.length-1; i < j;) { 
            int twoSum = inputArray[i] + inputArray[j];
            System.out.println(inputArray[i] +" + "+ inputArray[j] + " = " + twoSum);
            if (twoSum == target) {
                return new int[] {i+1, j+1}; // "+1" is to have 1-indexed output.
            } else if(twoSum > target) { // In this case, to get the sum equal to target, j has to move to it's left by decremetning.
                j--;
            } else { // Because the array is sorted, to get the sum equal to target i had to move right by incrementing.
                i++;
            }
        }
        return new int[]{-1, -1}; // If no target is found.
    }
}

package com.prep.twopointer;

import java.util.Arrays;

/**
 * Given an array nums of integers and integer k, return the maximum sum such
 * that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
 * exist satisfying this equation, return -1
 * https://leetcode.ca/2018-12-03-1099-Two-Sum-Less-Than-K/
 */
public class TwoSumLessThanK {

    public static void main(String[] args) {
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int[] nums = {34, 23, 1, 24, 75, 33, 54, 8};
        int k = 60;
        /*
        int[] nums = {10,20,30};
        int k = 15;
        */
        int result = twoSumLessThanK.twoSumLessThanK(nums, k);
        System.out.println("Result : " + result);
    }

    private int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums); //[1, 8, 23, 24, 33, 34, 54, 75]
        System.out.println(Arrays.toString(nums));
        int left=0;
        int right=nums.length-1;
        int max = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if(sum > k) {
                right--;
            } else if(sum < k) {
                if (sum > max) {
                    max = sum;
                }
                left++;
            }
        }
        return max;
    }
}

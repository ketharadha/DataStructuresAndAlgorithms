package com.prep.codingpatterns.twopointer;

/**
 * You are given an integer array height of length n. 
 * There are n vertical lines drawn such that the 
 * two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, 
 * such that the container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * 
 * Refer https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater maxArea = new ContainerWithMostWater();
        System.out.println("Most Water Container : " + maxArea.maxArea(height));
    }

    private int maxArea(int[] height) {
        int i = 0; 
        int j = height.length - 1;
        int maxArea = 0;

        while ( i < j) {
            int base = j - i; //Calculate the width between two heights.
            System.out.println("Base : " + base);
            
            //If both heights are not equal then, min height should be considered 
            //because with max height the container will spill water out.
            int depth = (height[i] < height[j]) ? height[i] : height[j];
            System.out.println("Depth : " + depth);

            //Calculate area of a container between two heights.
            int area = base * depth;
            System.out.println("Area : " + area);

            //Capture the greater height value then the previous height.
            if(area > maxArea) {
                maxArea = area;
                System.out.println("Max Area : " + maxArea);
            }

            //If left pointer value is lesser than the right pointer value move the left pointer right by incrementing.
            if (height[i] < height[j]) {
                i++;
            } else { // Heights at i and j are greater than or EQUALS(>=) to usecase.
                j--;
            }

            //The solution also works with below logic. Because equal heights at i and j usecase.

            //If left pointer value is greater than the right pointer value move the right pointer left by decrementing.
            /* if (height[i] > height[j]) {
                j--;
            } else { // Heights at i and j are less than or equal(<=) to usecase.
                i++;
            } */
        }

        return maxArea;
    }
}

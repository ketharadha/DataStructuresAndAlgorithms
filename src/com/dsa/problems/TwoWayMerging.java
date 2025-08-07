package com.dsa.problems;

import java.util.Arrays;

/**
 * Given Two sorted arrays. Merge the two arrays in such a way that the 
 * final array should be in sorted order.
 * Example : 
 * a = {3,5,8,9,10}
 * b = {4,6,7,11,14,15,16}
 */
public class TwoWayMerging {
    public static void main(String[] args) {
        int[] a = {3,5,8,9,10};
        int[] b = {4,6,7,11,14,15,16};
        twoWayMerge(a, b);
    }

    public static void twoWayMerge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int o = n + m;
        int[] c = new int[o];
        //We have three arrays. 
        //We need three pointers or variables to traverse through these arrays.
        int i = 0; 
        int j = 0;
        int k = 0;
        // a = {3,5,8,9,10}
        // b = {4,6,7,11,14,15,16}
        while (i < n && j < m) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
                //i++; k++;
            } else {
                c[k++] = b[j++];
                //j++; k++;
            }
        }
        while(i < n) {
            c[k++] = a[i++];
            //i++; k++;
        }
        while(j < m) {
            c[k++] = b[j++];
            //j++; k++;
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}

package com.dsa.problems;

import java.util.Arrays;

/**
 * QuickSort with lumotos partion take last element of an array as a pivot.
 * Compare the elements greater than pivot and swap them with the elements that are less than pivot element.
 * Track the swapped elements that are less than pivot using pivotIndex.
 * Swap pivot to pivotIndex. That means pivot elements find it right index where it should belong in a sorted array.
 */
public class QuickSortWithLumotosPartition {
    public static void main(String[] args) {
        int[] a = {16,3,9,12,1,5};
        System.out.println("Unsorted Array : " + Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println("Sorted Array : " + Arrays.toString(a));
    }

    private static void quickSort(int[] a, int l, int h) {
        if(l<h) {
            int pi = partition(a, l, h);
            quickSort(a, l, pi-1);
            quickSort(a, pi+1, h);
        }
    }

    private static int partition(int[] a, int l, int h) {
        int pivot = a[h];
        int j=l;
        //{16,3,9,12,1,5}
        for (int i=l; i < h; i++) {
            if(a[i] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            } 
        }
        int temp = a[j];
            a[j] = a[h];
            a[h] = temp;
            
        return j;
    }

}

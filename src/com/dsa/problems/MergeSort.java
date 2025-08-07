package com.dsa.problems;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] a = {16,3,9,12,1,5};

        System.out.println("Before Sort : " + Arrays.toString(a));
        mergeSort(a, 0, a.length-1);
        System.out.println("Sorted : " + Arrays.toString(a));

    }

    private static void mergeSort(int[] a, int l, int h) {
        if(l<h) {
            int m = (l+h)/2;
            mergeSort(a, l, m);
            mergeSort(a, m+1, h);
            merge(a, l, m, h);
        }
    }

    private static void merge(int[] a, int l, int m, int h) {
        int[] L = new int[m-l+1];
        int[] R = new int[h-m];

        for (int i = 0; i < L.length; i++) {
            L[i] = a[i+l];
        }
        for (int i = 0; i < R.length; i++) {
            R[i] = a[m+1+i];
        }

        System.out.println("Left Array : "+ Arrays.toString(L));
        System.out.println("Right Array : "+ Arrays.toString(R));

        int i = 0, j = 0, k = l;

        while(i < L.length && j < R.length) {
            if(L[i] < R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }

        while(i < L.length) {
            a[k++] = L[i++];
        }
        while(j < R.length) {
            a[k++] = R[j++];
        }
    }
}

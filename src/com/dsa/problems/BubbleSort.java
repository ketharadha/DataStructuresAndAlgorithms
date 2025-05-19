package com.dsa.problems;

import java.util.Arrays;

public class BubbleSort {

    private static int counter=0;
    public static void main(String[] args) {
        //int[] a = {3,6,5,15,9,1};
        int[] a = {1, 3, 5, 6, 9, 15};
        sort(a);
    }

    private static int[] sort(int[] a) {
    //3,6,5,15,9,1
    //3,5,6,15,9,1
    //3,5,6,9,15,1
    //3,5,6,9,1,15
    boolean isSorted=true;

        for (int j = 0; j < a.length-1; j++) { //j=4 then 1,3,5,6,9,15
            for (int i = 0; i < a.length-1; i++) {
                counter++;
                if(a[i]>a[i+1]) {//i=4 15 > 1
                    isSorted = false;
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            if(isSorted) {
                break;
            }
        }
        System.out.println("Iterations : " + counter);
        System.out.println(Arrays.toString(a));
        return a;
    }
}

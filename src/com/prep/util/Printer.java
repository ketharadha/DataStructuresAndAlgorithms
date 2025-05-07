package com.prep.util;

public class Printer {

/**
 * printArrays method takes an array as input and print on the console.
 * @param demoArray
 */
    public void printArrays(int[] demoArray) {
        System.out.println("Int Array : ");
        for (int i = 0; i < demoArray.length; i++) {
            System.out.print(demoArray[i]+",");
        }
    }

    public void printObjectArrays(Object[] demoArray) {
        System.out.println("Object Array : ");
        for (Object demoArray1 : demoArray) {
            System.out.print(demoArray1 + ",");
        }
    }

    public void print(Object element) {
        System.out.println(element);
    } 

    public void printInt(int element) {
        System.out.println(element);
    } 

    public void printString(String element) {
        System.out.println(element);
    } 
}

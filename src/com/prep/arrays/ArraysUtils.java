package com.prep.arrays;
public class ArraysUtils {

    public void printArrays(int[] demoArray) {
        System.out.println("Int Array : ");
        for (int i = 0; i < demoArray.length; i++) {
            System.out.print(demoArray[i]+",");
        }
    }

    public void printObjectArrays(Object[] demoArray) {
        System.out.println("\nObjectArray : ");
        for (Object demoArray1 : demoArray) {
            System.out.print(demoArray1 + ",");
        }
    }

    public static void main(String[] args) {
        ArraysUtils arraysUtils = new ArraysUtils();
        arraysUtils.demoArray();
    }

    public void demoArray() {
        /* int[] intArray = new int[5];
        intArray[0] = 5;
        intArray[1] = 1;
        intArray[2] = 2;
        intArray[3] = 4;
        intArray[4] = 6;
        intArray[4] = 7; */
        //intArray[5] = 8; //This will throw ArrayIndexOutOfBoundsException

        //You can also initialize an array using following syntax.
        int[] intArray = {5,1,2,4,6,7};
        printArrays(new int[]{5,1,2,4,6,7});
        System.out.println("\nLength Of Array : " + intArray.length);
        System.out.println("\nLast Element Of Array : " + intArray[intArray.length-1]);

        Object[] objArray = new Object[3];

        printObjectArrays(objArray);
    }
    
}

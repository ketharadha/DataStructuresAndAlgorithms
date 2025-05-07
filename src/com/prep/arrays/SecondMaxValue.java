package com.prep.arrays;

import com.prep.util.Printer;

//Before the interview
public class SecondMaxValue {

    public int getSecondMaxValue(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] > max) {
                secondMax = max;
                max = inputArray[i];
            } else if (inputArray[i] > secondMax && 
                       inputArray[i] != max) { //When existing max and the array element are both same, 
                                               //we should make sure both max and secondMax are not same. 
                secondMax = inputArray[i];
            }
        }

        return secondMax;
    }
 
    public static void main(String[] args) {
        SecondMaxValue secondMaxValue = new SecondMaxValue();
        int[] inputArray = {13,34,2,34,33,1};
        int maxValue = secondMaxValue.getSecondMaxValue(inputArray);
        Printer printer = new Printer();
        printer.printInt(maxValue);
    }
    
}

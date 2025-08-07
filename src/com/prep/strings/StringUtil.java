package com.prep.strings;

import java.util.Arrays;

public class StringUtil {

    private boolean isPalindrome(String text) {
        char[] charArray = text.toCharArray();
        int stringLen = charArray.length;
        for (int i = 0; i < stringLen; i++) {
            System.out.println(charArray[i] + " : " + charArray[(charArray.length - 1) - i]);
            if(charArray[i] != charArray[(stringLen - 1) - i]) {
                return false;
            }
        }
        return true;
    }

    private boolean areAnagrams(String s1, String s2) {
        char[] c1Array = s1.toCharArray();
        char[] c2Array = s2.toCharArray();

        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Invlaid Inputs and cannot form anagrams");
        }

        Arrays.sort(c1Array);
        Arrays.sort(c2Array);

        return Arrays.equals(c1Array, c1Array);
    }

    
    public static void main(String[] args) {
        StringUtil util = new StringUtil();
        System.out.println("Is Palindrome : " + util.isPalindrome("madam"));
        System.out.println("Are Anagrams : " + util.areAnagrams("Greek", "kGree"));
    }
}

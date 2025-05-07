package com.prep.strings;

public class StringUtil {
    public static void main(String[] args) {
        StringUtil util = new StringUtil();
        System.out.println("Is Palindrome : " + util.isPalindrome("madam"));
    }

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
}

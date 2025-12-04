package com.prep.strings;

import java.util.Arrays;

public class Anagrams {

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        anagrams.areAnagrams("Greek", "kGRee");
    }

    private boolean areAnagrams(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        if(s1.length() != s2.length()) {
            throw new IllegalArgumentException("The input string is not ");
        }

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
    

    //CompletableFuture and allOf(), supplyAsync(), thenComposeAsync()
    //Collections.syncronizedList
    //Collector.toMap()
}

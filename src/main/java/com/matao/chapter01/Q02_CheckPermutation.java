package com.matao.chapter01;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Q02_CheckPermutation {

    public static boolean permutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];   // assume all chars are ASCII

        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c : s2.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}

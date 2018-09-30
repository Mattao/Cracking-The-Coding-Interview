package com.matao.ArraysAndStrings;

import java.util.Arrays;

/**
 * Created by matao on 2018/9/30.
 * <p>
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Q2_Permutation {

    public static boolean bruteForceCheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return new String(chars1).equals(new String(chars2));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charSetCount = new int[128];
        for (char c : s1.toCharArray()) {
            charSetCount[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            charSetCount[c]--;
            if (charSetCount[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "ab"));
        System.out.println(checkPermutation("abc", "abc"));
        System.out.println(checkPermutation("123", "1234"));
        System.out.println(checkPermutation("", ""));
    }
}

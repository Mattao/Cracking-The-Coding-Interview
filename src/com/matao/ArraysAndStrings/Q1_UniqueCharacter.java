package com.matao.ArraysAndStrings;

/**
 * Created by matao on 2018/9/30.
 * <p>
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Q1_UniqueCharacter {

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueChars("123"));
        System.out.println(isUniqueChars(""));
        System.out.println(isUniqueChars(" "));
        System.out.println(isUniqueChars("a"));
        System.out.println(isUniqueChars("aba"));
    }
}

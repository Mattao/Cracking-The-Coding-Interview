package com.matao.chapter01;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * <p><br>
 * <strong>
 * Here we assume the character set is ASCII.
 * </strong>
 */
public class Q01_IsUnique {

    public static boolean isUniqueChars(String str) {
        if (str == null || str.length() > 128) {
            return false;
        }

        // ASCII character set
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

    public static boolean isUniqueCharsByBitSet(String str) {
        if (str == null || str.length() > 128) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int offset = str.charAt(i) - 'a';
            if ((checker & (1 << offset)) > 0) {
                return false;
            }
            checker |= (1 << offset);
        }
        return true;
    }
}

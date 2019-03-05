package com.matao.chapter01;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input: "Mr John Smith     ", 13
 * Output: "Mr%20John%20Smith"
 */
public class Q03_Urlify {

    public static char[] replaceSpaces(char[] str, int trueLength) {
        if (str == null) return null;

        int spaceCount = 0;
        for (char c : str) {
            if (' ' == c) {
                spaceCount++;
            }
        }

        int newLength = str.length + 2 * spaceCount;
        char[] newStr = new char[newLength];
        for (int i = trueLength - 1, j = newLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
            } else {
                newStr[j--] = str[i];
            }
        }
        return newStr;
    }
}

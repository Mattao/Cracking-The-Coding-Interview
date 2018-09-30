package com.matao.ArraysAndStrings;

/**
 * Created by matao on 2018/9/30.
 * <p>
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith   ", 13
 * Output: "Mr%20John%20Smith"
 */
public class Q3_Urlify {

    public static String replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = trueLength + 2 * spaceCount;
        char[] result = new char[newLength];
        int i = trueLength - 1;
        int j = newLength - 1;
        while (i >= 0 && j >= i) {
            if (str[i] != ' ') {
                result[j--] = str[i--];
            } else {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
                i--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "Mr John Smith   ";
        System.out.println(replaceSpaces(s.toCharArray(), 13));
    }
}

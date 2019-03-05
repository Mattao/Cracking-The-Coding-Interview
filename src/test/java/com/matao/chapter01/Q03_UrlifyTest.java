package com.matao.chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q03_UrlifyTest {

    @Test
    void testNull() {
        Assertions.assertArrayEquals(null, Q03_Urlify.replaceSpaces(null, 0));
    }

    @Test
    void testEmpty() {
        System.out.println("".toCharArray().length);
        Assertions.assertArrayEquals("".toCharArray(), Q03_Urlify.replaceSpaces("".toCharArray(), 0));
    }

    @Test
    void test() {
        String actual = "Mr John Smith";
        String expected = "Mr%20John%20Smith";
        Assertions.assertArrayEquals(expected.toCharArray(), Q03_Urlify.replaceSpaces(actual.toCharArray(), 13));
    }
}

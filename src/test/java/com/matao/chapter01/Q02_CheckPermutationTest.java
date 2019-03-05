package com.matao.chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q02_CheckPermutationTest {

    @Test
    void testNull() {
        Assertions.assertFalse(Q02_CheckPermutation.permutation(null, null));
    }

    @Test
    void testEmptyString() {
        Assertions.assertTrue(Q02_CheckPermutation.permutation("", ""));
    }

    @Test
    void testDifferentLengthString() {
        Assertions.assertFalse(Q02_CheckPermutation.permutation("abc", "abcc"));
    }

    @Test
    void testLongCase() {
        Assertions.assertTrue(Q02_CheckPermutation.permutation("Nice to meet you", "you ot meet ecNi"));
    }
}

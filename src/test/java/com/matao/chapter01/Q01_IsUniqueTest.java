package com.matao.chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_IsUniqueTest {

    @Test
    @DisplayName("test isUniqueChars with null")
    void testNull() {
        Assertions.assertFalse(Q1_IsUnique.isUniqueChars(null));
    }

    @Test
    @DisplayName("test isUniqueChars with empty string")
    void testEmptyString() {
        Assertions.assertTrue(Q1_IsUnique.isUniqueChars(""));
    }

    @Test
    @DisplayName("test isUniqueChars with single char")
    void testSingleChar() {
        Assertions.assertTrue(Q1_IsUnique.isUniqueChars("x"));
    }

    @Test
    @DisplayName("test isUniqueChars with multi-chars")
    void testMultiChars() {
        Assertions.assertFalse(Q1_IsUnique.isUniqueChars("fghjhjsfasd"));
    }

    /**
     * ----------------------------------------Test BitSet Solution below--------------------------------------------------------------------------
     */

    @Test
    @DisplayName("test isUniqueCharsByBitSet with null")
    void testBitSetNull() {
        Assertions.assertFalse(Q1_IsUnique.isUniqueCharsByBitSet(null));
    }

    @Test
    @DisplayName("test isUniqueCharsByBitSet with empty string")
    void testBitSetEmptyString() {
        Assertions.assertTrue(Q1_IsUnique.isUniqueCharsByBitSet(""));
    }

    @Test
    @DisplayName("test isUniqueCharsByBitSet with single char")
    void testBitSetSingleChar() {
        Assertions.assertTrue(Q1_IsUnique.isUniqueChars("x"));
    }

    @Test
    @DisplayName("test isUniqueCharsByBitSet with multi-chars")
    void testBitSetMultiChars() {
        Assertions.assertFalse(Q1_IsUnique.isUniqueChars("fghjhjsfasd"));
    }
}

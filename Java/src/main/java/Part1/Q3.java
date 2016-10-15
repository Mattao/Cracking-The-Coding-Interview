package Part1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by matao on 10/15/16.
 *
 * Given two strings, write a method to decide if one is a permutation of the other.
 * 给定两个字符串，确定其中一个字符串的字符重新排序后能否成为另一个字符串
 *
 * !!假定变位词区分大小写，空白也要考虑
 */
public class Q3 {

    public boolean permutation(String src, String dest) {
        if (src.length() != dest.length()) {
            return false;
        }
        return sort(src).equals(sort(dest));
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    /**
     * 假设都是ASCII字符，则用一个128长度的int数组，代表每个字符出现的次数
     */
    public boolean permutation2(String src, String dest) {
        if (src.length() != dest.length()) {
            return false;
        }
        int[] letters = new int[128];
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            letters[c]++;
        }

        for (int i = 0; i < dest.length(); i++) {
            char c = dest.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPermutation() {
        Assert.assertEquals(true, permutation("apple", "papel"));
        Assert.assertEquals(true, permutation("carrot", "tarroc"));
        Assert.assertEquals(false, permutation("hello", "llloh"));
    }

    @Test
    public void testPermutation2() {
        Assert.assertEquals(true, permutation2("apple", "papel"));
        Assert.assertEquals(true, permutation2("carrot", "tarroc"));
        Assert.assertEquals(false, permutation2("hello", "llloh"));
    }
}

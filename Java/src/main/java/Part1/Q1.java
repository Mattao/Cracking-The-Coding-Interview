package Part1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/15/16.
 * <p>
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * 实现一个算法，确定一个字符串的所有字符是否全都不同。不允许使用额外的数据结构。
 */
public class Q1 {

    /**
     * 假定为ASCII字符集，则共有128个字符。
     * 如果字符串长度大于128，则必定有重复字符。
     * 创建一个128大小的bool数组，对应每个字符是否出现过，默认为false
     *
     * 时间复杂度O(n), n为字符串长度
     */
    public boolean isUniqueChars(String str) {
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

    /**
     * 若字符串中仅包含小写字母a - z
     * 使用bit vector，减少空间。
     */
    public boolean isUniqueChars2(String str) {
        if (str.length() > 128) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {   // 取对应位是否为1，是1则该位之前已经被置过1，故重复
                return false;
            }
            checker |= (1 << val);  // 将对应位置1
        }
        return true;
    }

    @Test
    public void testIsUniqueChars() {
        Assert.assertEquals(true, isUniqueChars("abcdef"));
        Assert.assertEquals(false, isUniqueChars("matao"));
        Assert.assertEquals(false, isUniqueChars("abcdef*))%$%^&*("));
        Assert.assertEquals(true, isUniqueChars("<>ABC~"));
    }

    @Test
    public void testIsUniqueChars2() {
        Assert.assertEquals(true, isUniqueChars2("abcdef"));
        Assert.assertEquals(false, isUniqueChars2("matao"));
    }


}

package Part1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/16/16.
 *
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 *
 * 利用字符重复出现的次数，编写字符串压缩功能，
 * 比如 aabcccccaaa 编程 a2b1c5a3.
 * 若压缩后的字符串没有变短，则返回原先的字符串
 */
public class Q5 {

    public String compress(String str) {
        if (countCompress(str) >= str.length()) {
            return str;
        }
        char last = str.charAt(0);
        int repeatCount = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                repeatCount++;
            } else {
                result.append(last).append(repeatCount);
                repeatCount = 1;
                last = str.charAt(i);
            }
        }
        result.append(last).append(repeatCount);    // 末尾最后一组
        return result.toString();
    }

    /**
     * 每次单词变化记做一个divider，末尾也算
     */
    private int countCompress(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int dividerCounter = 1;
        char last = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (last != str.charAt(i)) {
                dividerCounter++;
                last = str.charAt(i);
            }
        }
        return dividerCounter * 2;
    }

    @Test
    public void testCountCompress() {
        Assert.assertEquals(8, countCompress("aabcccccaaa"));
        Assert.assertEquals(6, countCompress("abc"));
        Assert.assertEquals(10, countCompress("maattao"));
        Assert.assertEquals(0, countCompress(""));
    }

    @Test
    public void testCompressBad() {
        Assert.assertEquals("a2b1c5a3", compress("aabcccccaaa"));
        Assert.assertEquals("abc", compress("abc"));
        Assert.assertEquals("maattao", compress("maattao"));
        Assert.assertEquals("", compress(""));
    }
}

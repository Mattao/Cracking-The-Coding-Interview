package Part1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/15/16.
 * <p>
 * <p>
 * Write a method to replace all spaces in a string with'%20'.
 * You may assume that the string has sufficient space at the end of the string
 * to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: if imple- menting in Java,
 * please use a character array so that you can perform this opera- tion in place.)
 * <p>
 * EXAMPLE
 * Input: "Mr John Smith" Output: "Mr%20John%20Smith"
 * <p>
 * 将字符串中的空格全部替换为"%20"。
 */
public class Q4 {

    /**
     * 第一次扫描确定空格个数，一个空格被替换成%20,
     * 故每个空格多两个长度。
     * 尾部开始扫描
     */
    public String replaceSpace(String s) {
        int spaceCount = 0;
        int newLength;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        newLength = chars.length + 2 * spaceCount;
        char[] newChars = new char[newLength];

        int i = chars.length - 1;
        int j = newLength - 1;
        while (i >= 0) {
            if (chars[i] == ' ') {
                i--;
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
            } else {
                newChars[j--] = chars[i--];
            }
        }
        return new String(newChars);
    }

    @Test
    public void testReplaceSpace() {
        Assert.assertEquals("Mr%20John%20Smith", replaceSpace("Mr John Smith"));
    }
}

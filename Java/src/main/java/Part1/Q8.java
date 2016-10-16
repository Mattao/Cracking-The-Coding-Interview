package Part1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/16/16.
 *
 * Assume you have a method isSubstring which checks
 * if one word is a substring of another.
 * Given two strings, s i and s2, write code to check
 * if s2 is a rotation of si using only one call to isSubstring
 * (e.g.,"waterbottle"is a rotation of"erbottlewat").
 *
 * 假定有一个方法isSubString,可检查一个单词是否为其他字符串的字串。
 * 给定两个字符串s1和s2, 请检查s2是否为s1旋转而成，要求只能调用一次isSubString
 */
public class Q8 {

    /**
     * s1 = xy
     * s2 = yx
     * 不论xy之间的分割点在何处，yx肯定是xyxy的字串,
     * 即s2总是s1s1的字串
     */
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            if (isSubstring(s1s1, s2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        if (s1.contains(s2)) {
            return true;
        }
        return false;
    }

    @Test
    public void testIsRotation() {
        Assert.assertEquals(true, isRotation("waterbottle", "erbottlewat"));
        Assert.assertEquals(true, isRotation("taoma", "matao"));
        Assert.assertEquals(false, isRotation("taom", "mato"));
    }
}

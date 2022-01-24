import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();
        Arrays.sort(scharArr);
        Arrays.sort(tcharArr);
        return new String(scharArr).equals(new String(tcharArr));
     }
}
// @lc code=end


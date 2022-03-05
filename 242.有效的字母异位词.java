import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tchar);
        return new String(sChar).equals(new String(tchar));
     }
}
// @lc code=end


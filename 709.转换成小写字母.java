/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
    public String toLowerCase(String s) {
        // 大写变小写，小写变大写 char ^= 32
        // 大写变小写，小写变小写 char ｜= 32
        // 小写变大写，大写变大写 char &= -33
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = (char) (s.charAt(i) | 32);
        }
        return new String(chars);
    }
}
// @lc code=end


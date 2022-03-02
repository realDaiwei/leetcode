/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s.length < 2) return;
        int lo = 0, hi = s.length - 1;
        while (lo < hi) {
            char temp = s[lo];
            s[lo++] = s[hi];
            s[hi--] = temp;
        }
    }
}
// @lc code=end


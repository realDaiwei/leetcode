/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n == Integer.MIN_VALUE) return false;
        // 当全局只有一个1的时候，就是2次幂
        return (n & (n - 1)) == 0;
    }
}
// @lc code=end


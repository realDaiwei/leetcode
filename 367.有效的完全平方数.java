/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long lo = 0, hi = num, mid = 0;
        while (lo < hi) {
            mid = (lo + hi + 1) >> 1;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end


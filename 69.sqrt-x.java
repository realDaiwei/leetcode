
/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        long lo = 0, hi = x, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            if (mid * mid == x) return (int)mid;
            if (mid * mid < x) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return (int)lo;
    }
}
// @lc code=end


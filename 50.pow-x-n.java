/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        x = n > 0 ? x : 1 / x;
        return (n & 1) == 0 ? half * half : half * half * x;
    }   
}
// @lc code=end


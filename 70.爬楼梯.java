/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
    //    if (n < 3) return n;
    //    int[] dp = new int[n];
    //    dp[0] = 1;
    //    dp[1] = 2;
    //    for (int i = 2; i < n; i++) {
    //        dp[i] = dp[i - 1] + dp[i - 2];
    //    }
    //    return dp[n - 1];
        if (n < 3) return n;
        int j = 1, k = 2;
        while (n-- > 2) {
            k += j;
            j = k - j;
        }
        return k;
    }
}
// @lc code=end


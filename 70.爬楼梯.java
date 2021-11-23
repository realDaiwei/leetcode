/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 斐波那契
        // if (n < 3) return n;
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // dp
        // if (n < 3) return n;
        // int[] dp = new int[n + 1];
        // dp[1] = 1; dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        // 循环
        if (n < 3) return n;
        int j = 1, k = 2;
        while (n-- >= 3) {
            k = j + k;
            j = k - j;
        }
        return k;
    }
}
// @lc code=end


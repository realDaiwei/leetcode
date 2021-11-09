/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 递归斐波那契
        // if (n < 3) return n;
        // return climbStairs(n - 1) + climbStairs(n - 2); 

        // 循环DP
        // if (n < 3) return n;
        // int[] dp = new int[n + 1];
        // dp[0] = 1; dp[1] = 1;
        // for (int i = 2; i < n + 1; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        // 循环求解
        if (n < 3) return n;
        int i = 1, j = 1;
        while (--n > 0) {
            j = i + j;
            i = j - i;
        }
        return j;
    }
}
// @lc code=end


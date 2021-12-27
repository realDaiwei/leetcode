/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length + 1][3];
        // 0 冷冻期 1-买入 2-卖出
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][1] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]); 
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
// @lc code=end


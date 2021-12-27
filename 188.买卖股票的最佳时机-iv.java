
/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;
        // 如果当前 k >= prices.lengh * 2 
        if ((k >> 1) >= prices.length) return greedy(prices);
        int[][] dp = new int[k][2];
        // 初始化买入为最小的值
        for (int i = 0; i < dp.length; i++) dp[i][1] = Integer.MIN_VALUE;
        // 模拟两次交易那道题
        for (int p : prices) {
            dp[0][1] = Math.max(dp[0][1], -p);
            dp[0][0] = Math.max(dp[0][0], dp[0][1] + p);
            for (int i = 1; i < k; i++) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - p);
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + p);
            }
        }
        return dp[k - 1][0];
    }

    private int greedy(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) res += prices[i] - prices[i - 1]; 
        }
        return res;
    }
}

// @lc code=end


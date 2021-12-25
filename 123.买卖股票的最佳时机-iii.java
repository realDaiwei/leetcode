/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int in_1 = -prices[0], in_2 = -prices[0], out_1 = 0, out_2 = 0;
        for (int i = 1; i < prices.length; i++) {
            in_1 = Math.max(in_1, -prices[i]);
            out_1 = Math.max(out_1, in_1 + prices[i]);
            in_2 = Math.max(in_2, out_1 - prices[i]);
            out_2 = Math.max(out_2, in_2 + prices[i]);
        }
        return out_2;
    }
}
// @lc code=end


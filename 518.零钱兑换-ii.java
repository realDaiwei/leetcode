import oracle.jrockit.jfr.tools.ConCatRepository;

/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // 和爬楼梯是同一类问题
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 内外循环不能换。
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
// @lc code=end


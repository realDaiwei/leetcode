/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // 0 ~ nums.lenth - 2 和 1 ～ nums.length - 1
        return Math.max(baseRob(nums, 0, nums.length - 2), baseRob(nums, 1, nums.length - 1));
    }

    private int baseRob(int[] nums, int s, int e) {
        if (e - s == 1) return Math.max(nums[s], nums[e]);
        int[][] dp = new int[e - s + 1][2];
        dp[0][1] = nums[s];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1]  = dp[i - 1][0] + nums[s + i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }


}
// @lc code=end


/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxPos) return false;
            if (nums[i] + i > maxPos) maxPos = nums[i] + i; 
        }
        return true;
    }
}
// @lc code=end


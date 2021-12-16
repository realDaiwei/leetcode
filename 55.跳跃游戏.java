/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > pos) return false;
            pos = Math.max(pos, i + nums[i]);
        }
        return true;
    }
}
// @lc code=end


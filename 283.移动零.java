/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                 nums[j++] = nums[i];
            } 
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
// @lc code=end


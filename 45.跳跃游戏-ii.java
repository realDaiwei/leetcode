/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int cnt = 0, maxPos = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (end == i) {
                cnt += 1;
                end = maxPos;
            }     
        }
        return cnt;
    }
}
// @lc code=end


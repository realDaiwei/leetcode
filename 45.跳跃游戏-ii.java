/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // 贪心算法的精髓就是局部最优获取全局最优
        int cnt = 0, max = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            // 每一轮跳跃距离的计算最大值
            if (end == i) {
                // 当前这一轮跳跃中能到达的最远值
                end = max;
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end


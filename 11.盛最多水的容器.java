/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int res = 0, l =0, r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            res = Math.max(res, h * (r - l));
            if (height[r] > height[l]) l++; else r--;
        }
        return res;
    }
}
// @lc code=end


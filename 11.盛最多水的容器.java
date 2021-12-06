/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int lo = 0, hi = height.length - 1, area = 0;
        while (lo < hi) {
            area = Math.max(area, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] < height[hi]) lo++; else hi--;
        }
        return area;
    }
}
// @lc code=end


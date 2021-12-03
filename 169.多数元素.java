/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int cnt = 0, candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) candidate = nums[i];
            cnt = candidate == nums[i] ? cnt + 1 : cnt - 1;
        }
        return candidate;
    }
}
// @lc code=end


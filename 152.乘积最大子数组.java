/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(nums[i], nums[i] * min);
            max = Math.max(nums[i], nums[i] * max);
            res = Math.max(res, Math.max(max, min));
        }
        return res;
    }
}
// @lc code=end


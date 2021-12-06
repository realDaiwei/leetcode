/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
       if (k == 0) return;
       k %= nums.length;
       rotate(nums, 0, nums.length - 1);
       rotate(nums, 0, k - 1);
       rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }

    
}
// @lc code=end


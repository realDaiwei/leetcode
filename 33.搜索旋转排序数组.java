
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            if (nums[mid] == target) return mid;
            // 如果target在旋转点左侧时，向左规约的逻辑。
            if ((nums[0] <= target && nums[mid] > target) 
            // 如果target在旋转点右侧时，向左规约的逻辑。
            || (nums[0] >= nums[mid] && (target < nums[mid] || target >= nums[0]))) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}
// @lc code=end


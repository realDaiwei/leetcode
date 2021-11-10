import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi - 1] == nums[hi]) hi--;  
                }
                if (nums[lo] + nums[hi] + nums[i] < 0) lo++; else hi--;
            }
        }
        return res;
    }
}
// @lc code=end


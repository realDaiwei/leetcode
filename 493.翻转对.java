/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        // 双重循环暴力法
        // if (nums.length <= 1) return 0;
        // int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if ((nums[i] >> 1) > nums[j]) {
        //            ans++; 
        //         }
        //     }
        // }
        // return ans;
        return merge(nums, 0, nums.length - 1);
        
    }
    private int merge(int[] nums, int s, int e) {
        if (e <= s) return 0;
        int[] temp = new int[e - s + 1];
        int mid = (e + s) >> 1;
        int cnt = merge(nums, s, mid) + merge(nums, mid + 1, e);
        int l = s, r = mid + 1, c = 0;
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        while (l <= mid && r <= e) {
            temp[c++] = nums[l] > nums[r] ? nums[r++] : nums[l++];
        }
        while (r <= e) temp[c++] = nums[r++];
        while (l <= mid) temp[c++] = nums[l++];
        System.arraycopy(temp, 0, nums, s, e - s + 1);
        return cnt;
    }
}
// @lc code=end


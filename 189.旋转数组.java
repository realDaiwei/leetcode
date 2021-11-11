/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // 递归
        // k %= nums.length;
        // if (k == 0) return;
        // rotate(nums, 0, nums.length - 1);
        // rotate(nums, 0, k - 1);
        // rotate(nums, k, nums.length - 1);

        // 循环拷贝 timeout...
        // k %= nums.length;
        // if (k == 0) return;
        // int v = 0;
        // for (int i = 0; i < k; i++) {
        //     v = nums[nums.length - 1];
        //     System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        //     nums[0] = v;
        // }

        // 复制新数组
        k %= nums.length;
        if (k == 0) return;
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        System.arraycopy(arr, nums.length - k, nums, 0, k);
        System.arraycopy(arr, 0, nums, k, nums.length - k);

    }

    private void rotate(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }
}
// @lc code=end


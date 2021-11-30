import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, used, new LinkedList<>(), ans);
        return ans;
    }

    private void permute(int[] nums, int[] used, LinkedList<Integer> item, List<List<Integer>> res) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            item.addLast(nums[i]);
            used[i] = 1;
            permute(nums, used, item, res);
            used[i] = 0;
            item.removeLast();
        }
    }
}
// @lc code=end


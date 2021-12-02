import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        subsets(0, nums, new LinkedList<>(), ans);
        return ans;
    }

    private void subsets(int k, int[] nums, LinkedList<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = k; i < nums.length; i++) {
            list.addLast(nums[i]);
            subsets(i + 1, nums, list, res);
            list.removeLast();
        }
    }
}
// @lc code=end


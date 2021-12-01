import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int[] used = new int[nums.length];
        // permuteUnique(nums, used, new LinkedList<>(), new HashSet<>(), new StringBuilder(), ans);
        permuteUnique1(nums, used, new LinkedList<>(), ans);
        return ans;
    }

    //Memory Limit Exceeded >.<
    private void permuteUnique(int[] nums, int[] used, LinkedList<Integer> list, Set<String> set, 
        StringBuilder sb, List<List<Integer>> res) {
        if (list.size() == nums.length && !set.contains(sb.toString())) {
            set.add(sb.toString());
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] != 0) continue;
            used[i] = 1;
            sb.append("#").append(nums[i]);
            list.addLast(nums[i]);
            permuteUnique(nums, used, list, set, sb, res);
            list.removeLast();
            sb.delete(sb.length() - 2, sb.length());
            used[i] = 0;
        
        }
    }

    private void permuteUnique1(int[] nums, int[] used, LinkedList<Integer> list, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 1) {
                return;
            }
            used[i] = 1;
            list.addLast(nums[i]);
            permuteUnique1(nums, used, list, ans);
            list.removeLast();
            used[i] = 0;
        }
    }


}
// @lc code=end


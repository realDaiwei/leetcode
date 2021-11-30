import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(1, n, k, new LinkedList<>(), res);
        return res;

    }

    private void combine(int begin, int n, int k, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // n - (k - list.size()) + 1 剪枝优化，减少循环次数
        for (int i = begin; i <= n - (k - list.size()) + 1; i++) {
            list.addLast(i);
            combine(i + 1, n, k, list, res);
            list.removeLast();
        }
    }

    
}
// @lc code=end


import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, "", ans);
        return ans;
    }

    private void dfs(int open, int close, int n, String res, List<String> ans) {
        if (close == n) {
            ans.add(res);
            return;
        }
        if (open < n) {
            dfs(open + 1, close, n, res + "(", ans);
        }
        if (close < open) {
            dfs(open, close + 1, n, res + ")", ans);
        }
    }
    
}
// @lc code=end


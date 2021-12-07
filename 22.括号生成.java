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
       if (n == 0) return ans;
       slove(n, 0, 0, "", ans);
       return ans;
    }

    private void slove(int n, int open, int close, String str, List<String> ans) {
        if (close == n) {
            ans.add(str);
            return;
        }
        if (open < n) {
            slove(n, open + 1, close, str + "(", ans);
        }
        if (open > close) {
            slove(n, open, close + 1, str + ")", ans);
        }
    }

    
}
// @lc code=end


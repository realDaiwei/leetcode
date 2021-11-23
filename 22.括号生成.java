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
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        generateParenthesis(n, 0, 0, "", res);
        return res;
    }

    private void generateParenthesis(int n, int open, int close, String str, List<String> res) {
        if (close == n)  {
            res.add(str);
            return;
        } 
        if (open < n) generateParenthesis(n, open + 1, close, str + "(", res); 
        if (close < open) generateParenthesis(n, open, close + 1, str + ")", res); 
    }
}
// @lc code=end


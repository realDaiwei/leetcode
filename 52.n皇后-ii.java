/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {

    private int ans = 0;

    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return ans;
    }

    private void dfs(int n, int row, int col, int dale, int hill) {
        if (row >= n) {
            ans++;
            return;
        }
        int pos = (~(col | dale | hill)) & ((1 << n) - 1);
        while (pos != 0) {
            // x & -x 结果是保留最后一个1
            int next = pos & -pos;
            dfs(n, row + 1, col | next, (dale | next) << 1, (hill | next) >> 1);
            // x & x - 1 结果是去掉最后一个1
            pos &= pos - 1;
        }
    }
}
// @lc code=end


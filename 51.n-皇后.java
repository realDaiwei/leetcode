import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {

    int[] queen, dale, hill, col;
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        queen = new int[n];
        dale = new int[n * 2];
        hill = new int[n * 2];
        col = new int[n];
        dfs(0, n, ans);
        return ans;
    }

    private void dfs(int row, int n, List<List<String>> ans) {
        if (row >= n) {
            addAns(ans);        
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isOkPos(row, i)) continue;
            setQueen(row, i);
            dfs(row + 1, n, ans);
            remove(row, i);
        }
    }

    /**
     * 添加一个有效答案
     * @param ans
     */
    private void addAns(List<List<String>> ans) {
        List<String> item = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queen.length; i++) {
            for (int j = 0; j < queen.length; j++) {
                sb.append(queen[i] == j ? "Q" : ".");
            }
            item.add(sb.toString());
            sb = new StringBuilder();
        }
        ans.add(item);
    }

    /**
     * 判断当前位置是否是一个有效的位置
     * @param x 
     * @param y
     * @return
     */
    private boolean isOkPos(int x, int y) {
        return col[y] == 0 && hill[x + y] == 0 && dale[x - y + queen.length] == 0; 
    }

    /**
     * 设置queen的位置
     * @param x
     * @param y
     */
    private void setQueen(int x, int y) {
        queen[x] = y;
        col[y] = 1;
        hill[x + y] = 1;
        dale[x - y + queen.length] = 1;
    }
    

    /**
     * 移除queen
     * @param x
     * @param y
     */
    private void remove(int x, int y) {
        queen[x] = 0;
        col[y] = 0;
        hill[x + y] = 0;
        dale[x - y + queen.length] = 0;
    }
    

}
// @lc code=end


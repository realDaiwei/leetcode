import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 0) return ans;
        int[] col = new int[n];
        int[] hill = new int[n << 1];
        int[] dale = new int[n << 1];
        int[] queen = new int[n];
        slove(0, queen, col, hill, dale, ans);
        return ans;
    }

    private void slove(int row, int[] queen, int[] col, int[] hill, int[] dale, List<List<String>> ans) {
        if (row >= queen.length) {
            addResult(queen, ans);
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            if (!isOkPos(i, row, col, hill, dale)) continue;
            setQueen(i, row, queen, col, hill, dale);
            slove(row + 1, queen, col, hill, dale, ans);
            removeQueen(i, row, queen, col, hill, dale);
        }
    }

    private void addResult(int[] queue, List<List<String>> ans) {
        StringBuilder sb;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queue.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < queue.length; j++) {
                sb.append(queue[i] == j ? "Q" : ".");
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }

    private void setQueen(int i, int row, int[] queen, int[] col, int[] hill, int[] dale) {
        col[i] = 1;
        hill[i + row] = 1;
        dale[i - row + col.length] = 1;
        queen[row] = i;
    }

    private void removeQueen(int i, int row, int[] queen, int[] col, int[] hill, int[] dale) {
        col[i] = 0;
        hill[i + row] = 0;
        dale[i - row + col.length] = 0;
        queen[row] = 0;
    }

    private boolean isOkPos(int i, int row, int[] col, int[] hill, int[] dale) {
        return col[i] != 1 && hill[i + row] != 1 && dale[i - row + col.length] != 1;
    }


}
// @lc code=end


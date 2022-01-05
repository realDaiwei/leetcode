import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 */

// @lc code=start
class Solution {

    private static int[] x = new int[]{1, 0, -1, 0};
    private static int[] y = new int[]{0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        int startPosX = 0, startPosY = 0, stepTotalCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startPosX = i;
                    startPosY= j;  
                } else if (grid[i][j] == 0) {
                    stepTotalCnt += 1;
                }
            }
        }
        slove(grid, startPosX, startPosY, grid[startPosX][startPosY], res, 0, stepTotalCnt);
        return res.size();

    }

    public void slove(int[][] grid, int m, int n, int cur, List<Integer> res, int stepCnt, int stepTotalCnt) {
        if (cur == 2) {
            if (stepCnt == stepTotalCnt) {
                res.add(1); 
            }
            return;
        } 
        for (int i = 0; i < 4; i++) {
            if (m + x[i] >= grid.length || m + x[i] < 0 || n + y[i] >= grid[0].length 
                || n + y[i] < 0 || grid[m + x[i]][n + y[i]] == -1 || grid[m + x[i]][n + y[i]] == 1) continue;
            int next = grid[m + x[i]][n + y[i]];
            grid[m + x[i]][n + y[i]] = -1;
            if (next == 0) stepCnt++;
            slove(grid, m + x[i], n + y[i], next, res, stepCnt, stepTotalCnt);
            grid[m + x[i]][n + y[i]] = next;
            if (next == 0) stepCnt--;
        }
    }


}
// @lc code=end


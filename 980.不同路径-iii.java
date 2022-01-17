

/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 */

// @lc code=start
class Solution {

    public int uniquePathsIII(int[][] grid) {
        int startPosX = 0, startPosY = 0, stepTotalCnt = 1;
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
        return dfs(grid, startPosX, startPosY, stepTotalCnt);

    }

    public int dfs(int[][] grid, int m, int n, int stepCnt) {
        if (m >= grid.length || m < 0 || n >= grid[0].length || n < 0 || grid[m][n] == -1) return 0;
        if (grid[m][n] == 2) return stepCnt == 0 ? 1 : 0;
        int res = 0;
        grid[m][n] = -1;
        res += dfs(grid, m + 1, n, stepCnt - 1);
        res += dfs(grid, m - 1, n, stepCnt - 1);
        res += dfs(grid, m, n - 1, stepCnt - 1);
        res += dfs(grid, m, n + 1, stepCnt - 1);
        grid[m][n] = 0;
        return res;
        // if (cur == 2) {
        //     if (stepCnt == stepTotalCnt) {
        //         res.add(1); 
        //     }
        //     return;
        // } 
        // for (int i = 0; i < 4; i++) {
        //     if (m + x[i] >= grid.length || m + x[i] < 0 || n + y[i] >= grid[0].length 
        //         || n + y[i] < 0 || grid[m + x[i]][n + y[i]] == -1 || grid[m + x[i]][n + y[i]] == 1) continue;
        //     int next = grid[m + x[i]][n + y[i]];
        //     grid[m + x[i]][n + y[i]] = -1;
        //     if (next == 0) stepCnt++;
        //     slove(grid, m + x[i], n + y[i], next, res, stepCnt, stepTotalCnt);
        //     grid[m + x[i]][n + y[i]] = next;
        //     if (next == 0) stepCnt--;
        // }
    }


}
// @lc code=end


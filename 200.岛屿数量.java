import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    private static final int[] y = new int[] {0, -1, 0, 1};
    private static final int[] x = new int[] {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans += 1;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, int m, int n) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{m, n});
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            m = cur[0]; n = cur[1];
            if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] != '1') continue;
            grid[m][n] = '0';
            for (int i = 0; i < 4; i++) {
                queue.addLast(new int[]{m + x[i], n + y[i]});
            }
        }
    }

    // private void dfs(char[][] grid, int m, int n) {
    //     if (m < 0 || m >= grid.length || n < 0 || n >= grid[m].length || grid[m][n] == '0') return;
    //     grid[m][n] = '0';
    //     for (int i = 0; i < 4; i++) {
    //         dfs(grid, m + x[i], n + y[i]);
    //     }
    // } 

    
}
// @lc code=end


import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }


    /**
     * bfs 遍历
     * @param x 
     * @param y
     * @param grid
     */
    private void bfs(int x, int y, char[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int m = cur[0], n = cur[1];
            if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == '0') {
                continue;
            }
            grid[m][n] = '0';
            queue.addLast(new int[]{m + 1, n});
            queue.addLast(new int[]{m, n + 1});
            queue.addLast(new int[]{m - 1, n});
            queue.addLast(new int[]{m, n - 1});
        }
    }

    /**
     * dfs遍历
     * @param x
     * @param y
     * @param grid
     */
    private void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(x + 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x - 1, y, grid);
        dfs(x, y - 1, grid);
    }
}
// @lc code=end


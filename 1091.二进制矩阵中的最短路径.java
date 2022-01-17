import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        int res = 1, end = grid.length - 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollFirst();
                int x = cur[0], y = cur[1];
                if (x < 0 || x > end || y < 0 || y > end || grid[x][y] == 1) continue;
                grid[x][y] = 1;
                if (x == end && y == end) return res;
                queue.addLast(new int[]{x, y + 1});
                queue.addLast(new int[]{x + 1, y + 1});
                queue.addLast(new int[]{x + 1, y});
                queue.addLast(new int[]{x + 1, y - 1});
                queue.addLast(new int[]{x - 1, y});
                queue.addLast(new int[]{x - 1, y - 1});
                queue.addLast(new int[]{x, y - 1});
                queue.addLast(new int[]{x - 1, y + 1});
            }
            res++;
        }
        return -1;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {

    private static final int[] posX = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] posY = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0) return board;
        int m = click[0], n = click[1];
        if (board[m][n] == 'M') {
            board[m][n] = 'X';
            return board;
        }
        dfs(m, n, board);
        return board;
    }

    private void dfs(int m, int n, char[][] board) {
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] != 'E') {
            return;
        }
        char cnt = '0';
        for (int i = 0; i < 8; i++) {
            if (m + posX[i] >= board.length || m + posX[i] < 0 
                || n + posY[i] >= board[0].length || n + posY[i] < 0) continue;
            if (board[m + posX[i]][n + posY[i]] == 'M') cnt++;
        }
        if (cnt == '0') {
            board[m][n] = 'B';
        } else {
            board[m][n] = cnt;
            return;
        }
        for (int i = 0; i < 8; i++) {
            dfs(m + posX[i], n + posY[i], board);
        }
    }
}
// @lc code=end


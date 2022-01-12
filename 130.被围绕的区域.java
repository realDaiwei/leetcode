/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][board[i].length - 1] == 'O') dfs(i,  board[i].length - 1, board);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O') dfs(0, i, board);
            if (board[board.length - 1][i] == 'O') dfs(board.length - 1, i, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }

    /**
     * dfs 遍历
     * @param x 
     * @param y
     * @param board
     */
    private void dfs(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'Y';
        dfs(x + 1, y, board);
        dfs(x, y + 1, board);
        dfs(x - 1, y, board);
        dfs(x, y - 1, board);
    }


}
// @lc code=end


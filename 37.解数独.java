import java.security.cert.TrustAnchor;

import javax.swing.text.StyledEditorKit;

import javafx.scene.layout.Border;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {

    private int[][] row, col, square;

    public void solveSudoku(char[][] board) {
        init(board);
        dfs(0, 0, board);
    }

    private boolean dfs(int i, int j, char[][] board) {
        while (i < 9 && board[i][j] != '.') {
            if (j < 8) {
                j++;
            } else {
                i++;
                j = 0;
            }
        } 
        if (i == 9) return true;
        for (int k = 1; k <= 9; k++) {
            if (isOkNum(i, j, k)) {
                setNum(i, j, k, board);
                if (dfs(j + 1 >= 9 ? i + 1 : i, (j + 1) % 9, board)) return true;
                removeNum(i, j, k, board);
            }
        }
        return false;
    }

    /**
     * 初始化
     * @param board
     */
    private void init(char[][] board) {
        row = new int[10][10];
        col = new int[10][10];
        square = new int[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int k = board[i][j] - '0';
                row[i][k] = 1;
                col[j][k] = 1;
                square[i / 3 * 3 + j / 3][k] = 1;
            }
        }
    }

    /**
     * 是否是一个有效的数字
     * @param x
     * @param y
     * @param num
     * @return
     */
    private boolean isOkNum(int x, int y, int num) {
        return row[x][num] == 0 && col[y][num] == 0 && square[x / 3 * 3 + y / 3][num] == 0;
    }

    /**
     * 设置数字
     * @param x
     * @param y
     * @param num
     * @param board
     */
    private void setNum(int x, int y, int num, char[][] board) {
        board[x][y] = (char)(num + '0');
        row[x][num] = 1;
        col[y][num] = 1;
        square[x / 3 * 3 + y / 3][num] = 1;
    }

    /**
     * 移除数字
     * @param x
     * @param y
     * @param num
     * @param board
     */
    private void removeNum(int x, int y, int num, char[][] board) {
        board[x][y] = '.';
        row[x][num] = 0;
        col[y][num] = 0;
        square[x / 3 * 3 + y / 3][num] = 0;
    }
    
}
// @lc code=end


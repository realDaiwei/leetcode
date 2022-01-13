import javax.security.auth.kerberos.KerberosKey;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                // check col
                for (int k = 0; k < i; k++) {
                    if (board[i][j] == board[k][j]) {
                        return false;
                    }
                }

                // check row
                for (int k = 0; k < j; k++) {
                    if (board[i][j] == board[i][k]) {
                        return false;
                    } 
                }
                
                // check square
                for(int a = i + 1; a % 3 != 0; a++) {
                    for(int h = j / 3 * 3; h < j / 3 * 3 + 3; h++) {
                        if(board[i][j] == board[a][h]) 
                            return false;
                    }
                }        
            }
        }
        return true;
    }
}
// @lc code=end


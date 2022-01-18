import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @lc code=start
class Solution {

    private static final int[][] next = new int[][] {
        new int[]{1, 3},
        new int[]{0, 2, 4},
        new int[]{1, 5},
        new int[]{0, 4},
        new int[]{1, 3, 5},
        new int[]{2, 4}
    };

    public int slidingPuzzle(int[][] board) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(sb.toString());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.pollFirst();
                visited.add(str);
                if ("123450".equals(str)) return res;
                int idx = str.indexOf('0');
                for (int j = 0; j < next[idx].length; j++) {
                    String s = swap(str, idx, next[idx][j]);
                    if (!visited.contains(s)) queue.addLast(s);
                }
             }
             res++;
        }
        return -1;
    }


    /**
     * 交换字符串 i和j的char
     * @param str
     * @param i
     * @param j
     * @return
     */
    private String swap(String str, int i, int j) {
        if (i == j) return str;
        char[] chars = str.toCharArray();
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
        return new String(chars);
    }

}
// @lc code=end


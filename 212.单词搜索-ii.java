import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {

    private static final int[] y = new int[]{1, 0, -1, 0};
    private static final int[] x = new int[]{0, 1, 0, -1}; 
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> ans = new ArrayList<>();
        // 每一个点位都需要dfs上tire
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsShiftUpTrie(i, j, board, trie);
            }
        }
        for (String word : words) {
            if (trie.contain(word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    /**
     * dfs 把board数据保存到Trie树上
     * @param board 
     * @param trie
     */
    private void dfsShiftUpTrie(int m, int n, char[][] board, Trie trie) {
        char cur = board[m][n];
        board[m][n] = '0';
        trie = trie.insert(cur);
        for (int i = 0; i < 4; i++) {
            int x1 = m + x[i], y1 = n + y[i];
            if (x1 < 0 || x1 >= board.length || y1 < 0 || y1 >= board[0].length || board[x1][y1] == '0') {
                continue;
            }
            dfsShiftUpTrie(x1, y1, board, trie);
        }
        board[m][n] = cur;
    }
    
}

class Trie {

    public Trie[] nodes;
    private static final int size = 26;

    public Trie() {
        this.nodes = new Trie[size];
    }

    public Trie insert(char c) {
        if (this.nodes[c - 'a'] == null) {
            this.nodes[c - 'a'] = new Trie();
        }
        return this.nodes[c - 'a'];
    }

    public boolean contain(String str) {
        Trie trie = this;
        for (char c : str.toCharArray()) {
            if (trie.nodes[c - 'a'] == null) {
                return false;
            }
            trie = trie.nodes[c - 'a'];
        }
        return true;
    }
}
// @lc code=end




/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private static final int size = 26;
    private Trie[] nodes;
    private boolean isEnd;

    public Trie() {
        this.nodes = new Trie[size];
    }
    
    public void insert(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.nodes[c - 'a'] == null) {
                trie.nodes[c - 'a'] = new Trie();
            }
            trie = trie.nodes[c - 'a'];
        }
        trie.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie tire = this;
        for (char c : word.toCharArray()) {
            tire = tire.nodes[c - 'a'];
            if (tire == null) return false;
        }
        return tire.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie tire = this;
        for (char c : prefix.toCharArray()) {
            tire = tire.nodes[c - 'a'];
            if (tire == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end


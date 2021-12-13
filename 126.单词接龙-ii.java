import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    // 第一版，双向BFS + DFS的方式查找，BFS找到最短路径，然后再用最短路径的方式剪枝
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        int pathLen = findShortPath(beginWord, endWord, wordList);
        if (pathLen == 0) return ans;
        LinkedList<String> item = new LinkedList<>();
        item.addFirst(beginWord);
        getPath(endWord, beginWord, pathLen, item, ans, new HashSet<>(wordList));
        return ans;
    }

    // 通过双向BFS的方式找到最短路径
    private int findShortPath(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 0;
        while (!endSet.isEmpty() && !beginSet.isEmpty()) {
            if (endSet.size() < beginSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> set = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char letter = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (endSet.contains(word)) return len + 1;
                        if (!visited.contains(word) && wordSet.contains(word)) {
                            visited.add(word);
                            set.add(word);
                        }
                    }
                    chars[i] = letter;
                }
            }
            beginSet = set;
            len += 1;
        }
        return 0;
    }

    // 获取路径
    private void getPath(String target, String lastWord, int len, LinkedList<String> item, List<List<String>> ans, Set<String> wordSet) {
        if (len < 0) return;
        if (item.size() != 0 && target.equals(lastWord)) {
            ans.add(new ArrayList<>(item));
            return;
        }
        char[] charArr = lastWord.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char l = charArr[i];
            for (char c ='a'; c <= 'z'; c++) {
                charArr[i] = c;
                String next = new String(charArr);
                if (wordSet.contains(next) && !item.contains(next)) {
                    item.addLast(next);
                    getPath(target, next, len - 1, item, ans, wordSet);
                    item.removeLast();
                }
            }
            charArr[i] = l;
        }
        return;
    }
}
// @lc code=end


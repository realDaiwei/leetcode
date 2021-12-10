import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visitedSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> waveSet = new HashSet<>();
            for (String cur : beginSet) {
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char letter = chars[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        // if (letter == (char) j) continue;
                        chars[i] = (char) j;
                        String str = new String(chars);
                        if (endSet.contains(str)) return len + 1;
                        if (!visitedSet.contains(str) && wordSet.contains(str)) {
                            visitedSet.add(str);
                            waveSet.add(str);
                        } 
                    }
                    chars[i] = letter;
                }
            }
            beginSet = waveSet;
            len++;
        }
        return 0;
    }
}
// @lc code=end


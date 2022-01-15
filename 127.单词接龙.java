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
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> leftSet = new HashSet<>();
        Set<String> rightSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        leftSet.add(endWord);
        rightSet.add(beginWord);
        int len = 1;
        while (!leftSet.isEmpty() && !rightSet.isEmpty()) {
            if (rightSet.size() > leftSet.size()) {
                Set<String> set = leftSet;
                leftSet = rightSet;
                rightSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : leftSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char cur = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String str = new String(arr);
                        if (rightSet.contains(str)) return len + 1;
                        if (wordSet.contains(str) && !visited.contains(str)) {
                            temp.add(str);
                            visited.add(str);
                        }
                    }
                    arr[i] = cur;
                }
            }
            leftSet = temp;
            len++;
        }
        return 0;
    }
}
// @lc code=end


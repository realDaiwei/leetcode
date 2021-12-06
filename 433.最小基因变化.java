import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {

    private static final char[] letter = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visitedSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int len = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> set = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char l : letter) {
                        if (l == chars[i]) continue;
                        chars[i] = l;
                        String s = new String(chars);
                        if (endSet.contains(s)) return len + 1;
                        if (!visitedSet.contains(s) && bankSet.contains(s)) {
                            visitedSet.add(s);
                            set.add(s);
                        }
                    }
                    chars[i] = temp;
                }
            }
            len++;
            beginSet = set;
        }
        return -1;
    }
}
// @lc code=end


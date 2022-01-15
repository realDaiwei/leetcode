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
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int len = 1;
        startSet.add(start);
        endSet.add(end);
        while (!startSet.isEmpty() & !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> set = startSet;
                startSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String str : startSet) {
                char[] arr = str.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char cur = arr[i];
                    for (int j = 0; j < letter.length; j++) {
                        arr[i] = letter[j];
                        String word = new String(arr);
                        if (endSet.contains(word)) return len;
                        if (bankSet.contains(word) && !visited.contains(word)) {
                            temp.add(word);
                            visited.add(word);
                        }
                    }
                    arr[i] = cur;
                }
            }
            len++;
            startSet = temp;
        }
        return -1;
    }
}
// @lc code=end


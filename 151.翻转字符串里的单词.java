import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ' && sb.length() != 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (arr[i] != ' ') {
                    sb.append(arr[i]);
                }
            }
        }
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        Collections.reverse(list);
        return list.stream().collect(Collectors.joining(" "));
    }
}
// @lc code=end


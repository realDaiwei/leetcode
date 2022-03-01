/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        int idx = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length && j < idx; j++) {
                if (chars[j] != prefix.charAt(j)) {
                    idx = j;
                    break;
                }
            }
            if (idx > chars.length) {
                idx = chars.length;
            }
        }
        return idx == 0 ? "" : prefix.substring(0, idx);
    }
}
// @lc code=end


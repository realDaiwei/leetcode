/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c | 32));
            }
        }
        return isPalindrome(sb.toString().toCharArray());
    }

    private boolean isPalindrome(char[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            if (arr[lo++] != arr[hi--]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end


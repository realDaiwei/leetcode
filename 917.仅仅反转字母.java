/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') 
            || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                sb.append(s.charAt(i));
            }
        }
        char[] chars = sb.toString().toCharArray();
        reverse(chars, 0, chars.length - 1);
        sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'A' || s.charAt(i) > 'z' 
                || (s.charAt(i) < 'a' && s.charAt(i) > 'Z')) {
                sb.append(s.charAt(i));
            } else {
                sb.append(chars[idx++]);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char temp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = temp;
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
    //     if (isPalindrome(s)) {
    //         return true;
    //     }
    //     // 暴力破解法 超时
    //     for (int i = 0; i < s.length(); i++) {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(s.substring(0, i));
    //         sb.append(s.substring(i + 1, s.length()));
    //         if (isPalindrome(sb.toString())) {
    //             return true;
    //         }
    //     }
    //     return false;
    // O(n)的时间复杂度。
        int lo = 0, hi = s.length() - 1;
        char[] arr = s.toCharArray();
        while (lo < hi) {
            if (arr[lo] == arr[hi]) {
                lo++;
                hi--;
                continue;
            }
            return isPalindrome(arr, lo + 1, hi) || isPalindrome(arr, lo, hi - 1);
        }
        return true;
    }

    private boolean isPalindrome(char[] arr, int lo, int hi) {
        while (lo < hi) {
            if (arr[lo++] != arr[hi--]) {
                return false;
            }
        }
        return true;
    }

    // private boolean isPalindrome(String s) {
    //     int lo = 0, hi = s.length() - 1;
    //     while (lo < hi) {
    //         if (s.charAt(lo++) != s.charAt(hi--)) {
    //             return false;
    //         }
    //     }
    //     return  true;
    // }

}
// @lc code=end


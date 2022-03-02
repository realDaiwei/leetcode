/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int idx = 0;
        while (idx < chars.length) {
            simpleReverse(chars, idx, idx + k > chars.length ? chars.length - 1 : idx + k - 1);
            idx += 2 * k;
        }
        return new String(chars);
    }

    private void simpleReverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char c = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = c;
        }
    }
}
// @lc code=end


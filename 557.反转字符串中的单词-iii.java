/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int idx = 0, startIdx = 0;
        char[] arr = s.toCharArray();
        while (idx < s.length()) {
            if (arr[idx] == ' ') {
                simpleReverse(arr, startIdx, idx - 1);
                startIdx = idx + 1;
            }
            idx++;
        }
        simpleReverse(arr, startIdx, idx - 1);
        return new String(arr);
    }

    private void simpleReverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char temp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = temp;
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            letters[arr[i] - 'a'] += 1;  
        }
        for (int i = 0; i < arr.length; i++) {
            if (letters[arr[i] - 'a'] == 1) return i; 
        }
        return -1;
    }
}
// @lc code=end


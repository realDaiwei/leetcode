/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        int res = 0;
        char digit;
        int num;
        for (int i = 0; i < s.length(); i++) {
            digit = s.charAt(i);
            if (digit < '0' || digit > '9') {
                break;
            }
            num = digit - '0';
            if (res > Integer.MAX_VALUE / 10 || res * 10 > Integer.MAX_VALUE - num) {
                res = Integer.MAX_VALUE;
                break;
            }
            if (res < Integer.MIN_VALUE / 10 || res * 10 < Integer.MIN_VALUE + num) {
                res = Integer.MIN_VALUE;
                break;
            }
            res = res * 10 + sign * num;
        }
        return res;
    }
}
// @lc code=end


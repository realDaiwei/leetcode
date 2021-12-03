import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqsr");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        slove(0, digits, new StringBuilder(), ans, map);
        return ans;
    }

    private void slove(int k, String digits, StringBuilder sb, List<String> ans, Map<Character, String> map) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String nums = map.get(digits.charAt(k));
        for (int i = 0; i < nums.length(); i++) {
            sb.append(nums.charAt(i));
            slove(k + 1, digits, sb, ans, map);
            sb.delete(sb.length() - 1, sb.length());
        }

    }
}
// @lc code=end


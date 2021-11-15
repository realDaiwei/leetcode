import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
       Map<Character, Character> map = new HashMap<>();
       map.put(']', '[');
       map.put('}', '{');
       map.put(')', '(');
       LinkedList<Character> stack = new LinkedList<>();
       for (int i = 0; i < s.length(); i++) {
           if (map.containsKey(s.charAt(i))) {
               if (stack.isEmpty() || stack.pollFirst().charValue() != map.get(s.charAt(i))) {
                   return false;
               }
           } else {
               stack.addFirst(s.charAt(i));
           }
       }
       return stack.isEmpty();
    }
}
// @lc code=end


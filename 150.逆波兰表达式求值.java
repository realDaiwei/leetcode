import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int temp = 0;
        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+": 
                    stack.addLast(stack.pollLast() + stack.pollLast());
                    break;
                case "-":
                    temp = stack.pollLast(); 
                    stack.addLast(stack.pollLast() - temp);
                    break;
                case "*": 
                    stack.addLast(stack.pollLast() * stack.pollLast());
                    break;
                case "/":
                    temp = stack.pollLast(); 
                    stack.addLast(stack.pollLast() / temp);
                    break; 
                default: stack.addLast(Integer.parseInt(tokens[i]));       
                    break;
            }
        }
        return stack.peek();
    }
}
// @lc code=end


import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] pathes = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < pathes.length; i++) {
            if (".".equals(pathes[i]) || "".equals(pathes[i])) {
                continue;
            } else if ("..".equals(pathes[i])) {
                stack.pollLast();
            } else {
                stack.addLast(pathes[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append("/").append(stack.pollFirst());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
// @lc code=end


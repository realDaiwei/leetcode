import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 计算面积
        // if (height.length < 3) return 0;
        // int rh = 0, lh = 0, area = 0, heightArea = 0;
        // for (int i = 0; i < height.length; i++) {
        //     heightArea += height[i];
        //     rh = Math.max(rh, height[i]);
        //     lh = Math.max(lh, height[(height.length - 1) - i]);
        //     area += lh + rh;
        // }
        // return area - (rh * height.length) - heightArea;

        // 使用栈的解决
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                int top = stack.pollLast();
                if (stack.isEmpty()) break;
                int width = i - stack.peekLast() - 1;
                int h = Math.min(height[i], height[stack.peekLast()]) - height[top];
                res += h * width;
            }
            stack.addLast(i);
        }
        return res;
    }
}
// @lc code=end


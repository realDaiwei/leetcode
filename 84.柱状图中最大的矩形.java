import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 暴力解法 
        // int res = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     int h = heights[i], left = i, right = i;
        //     while (left - 1 >= 0 && heights[left - 1] >= heights[i]) left--;
        //     while (right + 1 < heights.length && heights[i] <= heights[right + 1]) right++;
        //     res = Math.max(res, (right - left + 1) * h);
        // }
        // return res;

        // 使用栈的方式优化计算，这里需要注意，出栈操作一定要先poll后peek 因为这样利用栈底的-1才会算到最后一个
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] > heights[i]) {
                res = Math.max(res, heights[stack.pollFirst()] * (i - stack.peekFirst() - 1));
            }
            stack.addFirst(i);
        }
        while (stack.peekFirst() != -1) {
            res = Math.max(res, heights[stack.pollFirst()] * (heights.length - stack.peekFirst() - 1));
        }
        return res;
    }
}
// @lc code=end


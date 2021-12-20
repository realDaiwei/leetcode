/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0, hi = matrix.length * matrix[0].length - 1, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            int midTarget = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (midTarget == target) return true;
            if (midTarget > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return matrix[lo / matrix[0].length][lo % matrix[0].length] == target;
    }
}
// @lc code=end

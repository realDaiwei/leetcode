/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row = null;
        for (int[] col : matrix) {
            if (col[0] <= target && col[col.length - 1] >= target) {
                row = col;
                break;
            }
        }
        if (row == null) return false;
        int lo = 0, hi = row.length - 1, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            if (row[mid] == target) return true;
            if (row[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return row[lo] == target;
    }
}
// @lc code=end

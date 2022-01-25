import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1]; 
        for (int i = 1; i < intervals.length; i++) {
            //区间包含直接跳过
            if (right >= intervals[i][1]) continue;
            if (right >= intervals[i][0]) {
                //包含部分，right延长
                right = intervals[i][1];
            } else {
                // 没有包含部分，这个区间结束
                ans.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }  
        ans.add(new int[]{left, right});      
        return ans.toArray(new int[0][]);
    }
}
// @lc code=end


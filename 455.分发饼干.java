import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0, j = 0;
        for (int i = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                j++;
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end


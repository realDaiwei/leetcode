import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {

    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{1, 0, -1, 0};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obSet = new HashSet<>();
        for (int[] ob : obstacles) {
            obSet.add(ob[0] + "#" + ob[1]);
        }
        int dist = 0, x = 0, y = 0, max = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                dist = (dist + 3) % 4;
            } else if (cmd == -1) {
                dist = (dist + 1) % 4;
            } else {
                while (cmd-- > 0) {
                    int nx = x + dx[dist];
                    int ny = y + dy[dist];
                    if (!obSet.contains(nx + "#" + ny)) {
                        x = nx; 
                        y = ny;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}
// @lc code=end


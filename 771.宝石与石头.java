/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // if (jewels.length() == 0 || stones.length() == 0) {
        //     return 0;
        // }
        // // 暴力法
        // char[] jewelsArr = jewels.toCharArray();
        // char[] stonesArr = stones.toCharArray();
        // int res = 0;
        // for (int i = 0; i < jewelsArr.length; i++) {
        //     for (int j = 0; j < stonesArr.length; j++) {
        //         if (jewelsArr[i] == stonesArr[j]) {
        //             res++;
        //         }
        //     }
        // }
        // return res;

        // hash法
        if (jewels.length() == 0 || stones.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] jewelsArr = jewels.toCharArray();
        int res = 0;
        for (int i = 0; i < jewelsArr.length; i++) {
            set.add(jewelsArr[i]);
        }
        char[] stonesArr = stones.toCharArray();
        for (int i = 0; i < stonesArr.length; i++) {
            if (set.contains(stonesArr[i])) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end


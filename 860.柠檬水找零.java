/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                if (five < 1) {
                    return false;
                }
                five--;
                ten++;
            }
            if (bills[i] == 20) {
                if (five == 0 || (ten == 0 && five < 3)) {
                    return false;
                }
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
					five -= 3;
				}
            }
    	}
		return true;
    }
}
// @lc code=end


import java.util.ArrayList;

import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = toArr(p);
        for (int i = p.length() - 1; i < s.length(); i++) {
            String str = s.substring(i - (p.length() - 1), i + 1);
            if (isAnagram(arr, toArr(str))) {
                ans.add(i - (p.length() - 1));
            }
        }
        return ans;
    }

    private boolean isAnagram(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] toArr(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }
}
// @lc code=end


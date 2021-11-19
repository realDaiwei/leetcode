import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            if (!map.containsKey(new String(charArr))) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(new String(charArr), list);
            } else {
                map.get(new String(charArr)).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end


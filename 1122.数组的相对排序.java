import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.containsKey(arr1[i]) ? map.get(arr1[i]) + 1 : 1);    
        }
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            int cur = map.get(arr2[i]);
            while (cur-- > 0) {
                ans[idx++] = arr2[i];
            }
            map.remove(arr2[i]);
        }
        if (!map.isEmpty()) {
            int i = 0;
            int[] temp = new int[map.size()];
            for (Integer key : map.keySet()) {
                temp[i++] = key;
            }
            Arrays.sort(temp);
            for (int j = 0; j < temp.length; j++) {
                int cur = map.get(temp[j]);
                while (cur-- > 0) {
                    ans[idx++] = temp[j];
                }
            }
        }
        return ans;
        
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
 * @lc app=leetcode.cn id=609 lang=java
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = splitSingleContentPath(paths);
        groupByFileContent(list, map);
        return map.values().stream().filter(item -> item.size() > 1).collect(Collectors.toList());
    }

    /**
     * 多文粘合拆分成单个文件名字
     */
    private List<String> splitSingleContentPath(String[] pathes) {
        List<String> res = new ArrayList<String>();
        for (String path : pathes) {
            String[] arr = path.split(" ");
            for (int i = 1; i < arr.length; i++) {
                res.add(arr[0] + "/" + arr[i]);
            }
        }
        return res;
    }

    /**
     * 按照文件内容进行分类
     * @param list
     * @return
     */
    private void groupByFileContent(List<String> list, Map<String, List<String>> map) {
        for (String str : list) {
            String key = str.substring(str.lastIndexOf("("));
            if (map.containsKey(key)) {
                map.get(key).add(str.substring(0, str.lastIndexOf("(")));
            } else {
                List<String> item = new ArrayList<>();
                item.add(str.substring(0, str.lastIndexOf("(")));
                map.put(key, item);
            }
        }
    }
}
// @lc code=end


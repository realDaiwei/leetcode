import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            // 这个size 是关键点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.pollLast();
                item.add(cur.val);
                List<Node> list = cur.children;
                if (list != null && list.size() > 0) {
                    for (Node child : list) {
                        queue.addFirst(child);
                    }
                }
            }
            ans.add(item);
        }
        return ans;
    }
}
// @lc code=end


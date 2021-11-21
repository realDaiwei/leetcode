import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        // 递归处理方法
        // List<Integer> res = new ArrayList<>();
        // if (root == null) return res;
        // perorder(root, res);
        // return res;

        // 循环方式
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
           Node node = stack.pollLast();
           res.add(node.val);
           List<Node> list = node.children;
           for (int i = list.size() - 1; i >= 0; i--) {
               if (list.get(i) != null) {
                   stack.addLast(list.get(i));
               }
           }           
        }
        return res;
    }

    private void perorder(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        List<Node> list = root.children;
        for (Node node : list) {
            perorder(node, res);
        }
    }
}
// @lc code=end


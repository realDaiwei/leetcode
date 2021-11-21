import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };


class Solution {
    public List<Integer> postorder(Node root) {
        // 递归循环
        // List<Integer> res = new ArrayList<>();
        // if (root == null) return res;
        // postorder(root, res);
        // return res;

        // 循环实现
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) { 
            Node cur = stack.pollLast();
            res.addFirst(cur.val);
            for (Node node : cur.children) {
                stack.addLast(node);
            }
        }
        return res;
    }

    // private void postorder(Node root, List<Integer> res) {
    //     if (root == null) return;
    //     List<Node> list = root.children;
    //     if (list != null) {
    //         for (Node node : list) {
    //             postorder(node, res);
    //         }
    //         res.add(root.val);
    //     }
    // }
}
// @lc code=end


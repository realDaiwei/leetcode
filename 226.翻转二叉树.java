import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 递归大法好
        // if (root == null) return root;
        // TreeNode lNode = root.left;
        // TreeNode rNode = root.right;
        // root.right = invertTree(lNode);
        // root.left = invertTree(rNode); 
        // return root;

        if (root == null) return root;
        // 层序遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // swap
                TreeNode cur = queue.pollLast();
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) queue.addFirst(cur.left);
                if (cur.right != null) queue.addFirst(cur.right);
            }
        }
        return root;
    }
}
// @lc code=end


import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        // return maxDepth(root, 0);
        int depth = 0;
        if (root == null) return depth;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollLast();
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
            }
        }
        return depth;   
    }

    // 最大的深度
    private int maxDepth(TreeNode root, Integer depth) {
        if (root == null) return depth;
        return Math.max(maxDepth(root.left, depth), 
        maxDepth(root.right, depth)) + 1;
    }
}
// @lc code=end


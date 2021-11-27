import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        // if (root == null) return 0;
        // return minDepth(root, 0, Integer.MAX_VALUE);
        
        // 正常的递归
        // if (root == null) return 0;
        // if (root.left == null && root.right == null) return 1;
        // int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        // if (root.left != null) left = minDepth(root.left);
        // if (root.right != null) right = minDepth(root.right);
        // return Math.min(left, right) + 1;

        // BFS循环 yyds
        int res = 0;
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollLast();
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
            }
        }
        return res;
    }

    //减枝, 测试下来性能并没有提升多少。。
    public int minDepth(TreeNode root, int depth, int min) {
        if (root.left == null && root.right == null) return depth + 1;
        if (depth >= min) return min;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (root.left != null) left = minDepth(root.left, depth, min);
        if (root.right != null) right = minDepth(root.right, depth, left);
        return Math.min(left, right) + 1; 
    }

}
// @lc code=end


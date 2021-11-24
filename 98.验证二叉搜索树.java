/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }


    public boolean valid(TreeNode root, Integer hi, Integer lo) {
        // if (root == null) return true;
        // boolean leftRes = true, rightRes = true;
        // if (root.left != null) {
        //     leftRes = root.left.val < root.val && (lo == null || root.left.val > lo);
        // }
        // if (root.right != null) {
        //     rightRes = root.right.val > root.val && (hi == null || root.right.val < hi);
        // }
        // return leftRes && rightRes && valid(root.left, root.val, lo) 
        //     && valid(root.right, hi, root.val);

        if (root == null) return true;
        if (hi != null && hi <= root.val) return false;
        if (lo != null && lo >= root.val) return false;
        return valid(root.left, root.val, lo) && valid(root.right, hi, root.val);
    }

}
// @lc code=end


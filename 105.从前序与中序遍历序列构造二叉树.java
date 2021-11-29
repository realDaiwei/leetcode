/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    
    Map<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        initMap(inorder);
        return buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }

    private TreeNode buildTree(int perStart, int perEnd, int[] preorder, int inStart, int inEnd, int[] inorder) {
        if (inStart > inEnd || perStart > preorder.length - 1) return null;
        TreeNode node = new TreeNode(preorder[perStart]);
        int pos = map.get(preorder[perStart]);
        node.left = buildTree(perStart + 1, pos, preorder, inStart, pos - 1, inorder);
        node.right = buildTree(pos - inStart + perStart + 1, perEnd, preorder, pos + 1, inEnd, inorder);
        return node;
    }


    private int findPos(int[] arr, int t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) return i;
        }
        return -1;
    }

    private void initMap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
    }
}
// @lc code=end


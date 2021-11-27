import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split("#")));
        return deserialize(list);
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("!").append("#");
        }  else {
            sb.append(root.val).append("#");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    private TreeNode deserialize(LinkedList<String> list) {
        String str = list.poll();
        if (str == null || "!".equals(str)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }

    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end


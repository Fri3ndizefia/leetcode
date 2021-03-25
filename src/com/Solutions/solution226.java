package com.Solutions;

/**
 * 翻转二叉树
 *
 * 简单递归一下每次的左子树和右子树
 * 相反的接回去
 */
public class solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = invertTree(root.right);
        TreeNode rightRoot = invertTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}

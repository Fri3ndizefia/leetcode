package com.Solutions;

/**
 * 二叉树展开链表
 */
public class solution114 {
    public void flatten(TreeNode root) {
        if(root == null ) return ;

        flatten(root.left);
        flatten(root.right);

        // 1. 拉平
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        // 2.拼接
        TreeNode rightTail = root;
        while(rightTail.right!=null) rightTail = rightTail.right;
        rightTail.right = right;
    }
}

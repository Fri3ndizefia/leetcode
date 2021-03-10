package com.Solutions;

/**
 * 二叉树的坡度
 */
public class solution563 {
    int depth = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return depth;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        depth += Math.abs(left-right);
        return left + right + root.val;
    }
}

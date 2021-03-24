package com.Solutions;

/**
 * 二叉树的镜像
 *
 *
 */

public class solution1855 {

    /**
     * 递归方法
     * 左节点就是root的右节点
     * 右节点就是root的左节点
     * 如此递归，就可以得到镜像
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root){
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }


}

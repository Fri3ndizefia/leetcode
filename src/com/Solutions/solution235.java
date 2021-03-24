package com.Solutions;

/**
 * 搜索二叉树的最近公共父节点（祖先）
 *
 * 情况在于是一个搜索二叉树，中序遍历是排序好了的数组的情况
 *
 * 剑指 68的区别是，那个二叉树不是搜索二叉树，对应solution1903
 */
public class solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while(true){
            if(root.val < p.val){
                root = root.right;
            }else if(root.val > q.val){
                root = root.left;
            }else{
                break;
            }
        }
        return root;
    }
}

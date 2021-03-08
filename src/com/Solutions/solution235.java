package com.Solutions;

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

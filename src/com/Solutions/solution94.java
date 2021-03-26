package com.Solutions;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的 中序遍历
 * 左 根 右
 */
public class solution94 {

    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    public List<Integer> inorderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}

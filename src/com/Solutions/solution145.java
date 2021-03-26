package com.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树 的后序遍历
 *
 */
public class solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                res.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}

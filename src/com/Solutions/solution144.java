package com.Solutions;

import java.util.*;

/**
 * 二叉树 前序遍历
 */
public class solution144 {

    /**
     * 非递归版
     * Stack可以放入null值
     * ArrayDeque不可以，它需要靠null判断元素是否存在
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                res.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 非递归版
     * 另外一种思路
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }


    /**
     * 递归版
     * 简单记住根 左 右 即可
     * @param root
     * @return
     */
    public List<Integer> preoorderTraversal_recursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}

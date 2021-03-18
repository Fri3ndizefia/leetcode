package com.Solutions;

import java.util.Stack;

/**
 * 判断一个二叉树是否是搜索二叉树
 *
 * 搜索二叉树的性质是中序遍历下来的结果是有序数组
 */

public class solution98 {
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer inorder = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (inorder !=null && root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


    /**
     * 递归上下界判断
     *
     * 中序遍历结果  左 小于 根  小于 右
     * 那么 左节点的判断范围就是 [MIN_VALUE, 根的值）
     *      右节点的判断范围就是 （根的值，MAX_VALUE]
     * 递归判断下去 每一个 子"根" 节点
     * @param root
     * @return
     */
    public boolean isValidBST_(TreeNode root) {
        return isValidBST_(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST_(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST_(node.left, lower, node.val) && isValidBST_(node.right, node.val, upper);
    }
}

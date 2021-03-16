package com.Solutions;

/**
 * 检查一个树是否是另外一个树的子树
 */
public class solution1926 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return isTreeEql(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
    private boolean isTreeEql(TreeNode t1, TreeNode t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isTreeEql(t1.left, t2.left) && isTreeEql(t1.right, t2.right);
    }

}

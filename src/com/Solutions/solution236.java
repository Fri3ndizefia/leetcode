package com.Solutions;

public class solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        if (root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1，p和q都不在root节点的树内
        // 此题不适用，算是引申出来的答案。去掉也无所谓
        if (left == null && right == null) {
            return null;
        }

        // 情况2，在root为根节点的情况下，找到了left和right
        // 也就是说，root就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 情况3，找到了一个，另外一找不到
        // 这种情况一般是另外一个在下一层去了。非空的那个就是最近的公共祖先。
        return left == null ? right : left;
    }
}

package com.Solutions;

/**
 * 普通二叉树的最近公共祖先
 */
public class solution1903 {

    /**
     * 究极递归法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        return l == null ? r : (r == null ? l : root);
    }

    /**
     * 详细理解递归
     * 祖先的定义：若节点p在节点root的左（右）子树中，或者p == root，则root是p的祖先
     * <p>
     * 考虑通过递归对二叉树进行后序遍历（左右根），当遇到节点p或q时返回。从底至顶回溯，当节点p，q在
     * 节点的异侧时，节点root即是最近公共祖先，向上返回root
     * <p>
     * 递归解析：
     * 终止条件
     * 1 当越过叶子节点，返回null
     * 2 当root等于p，q，返回root
     * 地推工作
     * 1 开启递归左子节点，返回值记为left；
     * 2 开启递归右子节点，返回值记为right；
     * 返回值
     * 1 left和right同时为空；root的左右都不包含p，q返回null
     * 2 left和right同时不为空；p和q分在root异侧，返回root
     * 3 left空，right不为空，p，q都不在root的左子树中，直接返回right
     * 3-1 p，q其中一个在root的右子树中，right指向了p（假设）
     * 3-2 p，q两节点都在root的右子树中，right指向最近公共祖先节点
     * 4 left不为空，right为空，返回left，同3
     */

    public TreeNode findAncesotr(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || q == root || p == root) {
            return root;
        }
        TreeNode left = findAncesotr(root.left, p, q);
        TreeNode right = findAncesotr(root.right, p, q);
        if(left == null && right == null) return null;// 1
        if(left == null) return right;//3
        if(right == null) return left;//4
        return root; //2
    }
}

package com.Solutions;

/**
 * 节点路径最大差值
 *
 * 深度优先搜索
 */

public class solution1026 {

    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root){
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        if (node.left == null && node.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        dfs(node.left, min, max);
        dfs(node.right, min, max);

    }
}

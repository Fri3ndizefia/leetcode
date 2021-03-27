package com.Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class solution623 {

    /**
     * 广度优先算法
     * 一层一层找，
     * 找到目标层之后停止寻找
     * 将这一层的节点进行添加新的 左右 node即可
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 1;
        while (d < depth - 1) {
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);
            }
            queue = temp;
            ++d;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }

    /**
     * 深度优先搜索（递归版）
     */
    public TreeNode addOneRow_DFS(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    private void insert(int val, TreeNode node, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        }else{
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }
}

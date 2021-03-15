package com.Solutions;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最深层数
 */
public class solution104 {

    /**
     * 深度优先搜索 DFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 广度优先搜索
     * 拓展了几次，层数就加了几，因此直接可以得到最大深处。
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root){
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }
            ++ans;
        }
        return ans;
    }
}

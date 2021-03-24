package com.Solutions;

import java.util.*;

/**
 * 剑指 32
 * 从上到下打印二叉树 II
 * BFS 一层一层打印二叉树罢了
 */

public class solution1860 {
    /**
     * queue.size 是一个好方法
     * 根据size来决定有这一层有多少个节点，同时把节点放进去
     * 用队列的方式可以保证先进先出，放左再放右即可
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; --i) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            list.add(level);
        }
        return list;
    }
}

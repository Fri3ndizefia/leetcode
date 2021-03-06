package com.DataStructure.Tree;

import com.DataStructure.Tree.TraversalNotRecursion.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DFSandBFS {
    /*
    DFS depth first search
    深度优先搜索，根出发，从左开始遍历，一直遍历到最左最深处。
            1
        2       6
      3   4       7
         5      8   9
    DFS 遍历出来的结果就是 [1,2,3,4,5,6,7,8,9]
     */
    // DFS 就是简单的递归实现
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    /*
    BFS Breath first search
    广度优先搜索，使用队列数据结构，一层一层的进行遍历
    BFS 遍历出来的结果 [1,2,6,3,4,7,5,8,9]
     */
    //
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /* ***** BFS 应用： 层序遍历 *****
    基于BFS，实现每一层的遍历，层序遍历
    层序遍历，将每一层的数据遍历出来
    从而遍历得到一个二维数组
    [
    [1],
    [2,6],
    [3,4,7],
    [5,8,9]
    ]
     */
    // 一口气遍历掉每一层的
    public List<List<Integer>> levelBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }

    /* ***** BFS 应用：最短路径
    无权最短路径问题 每一个节点的距离都是1
    带权最短路径问题 Dijkstra算法

     */

}

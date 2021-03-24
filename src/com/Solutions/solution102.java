package com.Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 层序遍历，广度优先搜索算法
 *
 * BFS输出
 */

public class solution102 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        int levelNum = 0;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            levelNum = treeQueue.size();
            List<Integer> levelList = new ArrayList<>();
            while(levelNum > 0){
                TreeNode tempNode = treeQueue.poll();
                if(tempNode != null){
                    levelList.add(tempNode.val);
                    treeQueue.add(tempNode.left);
                    treeQueue.add(tempNode.right);
                }
                levelNum--;
            }
            if(levelList.size() > 0){
                resultList.add(levelList);
            }
        }
        return resultList;
    }
}

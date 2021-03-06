package com.DataStructure.Tree;

/*
非递归方法 会用到的一般都是 Stack
 */

import java.util.*;

public class TraversalNotRecursion {




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "val: " + val;
        }

        //  Visit function
        public void visit(TreeNode node){
            System.out.println(node.val + " ");
        }

        //  Traversal with Recursion
        public void traversalRecursion(TreeNode node, String type){
            if(node == null){
                return;
            }
            switch (type){
                case "pre":
                    visit(node); // visit root node;
                    visit(node.left);
                    visit(node.right);
                    break;
                case "mid":
                    visit(node.left);
                    visit(node); // visit root node;
                    visit(node.right);
                    break;
                case "post":
                    visit(node.left);
                    visit(node.right);
                    visit(node);
            }

        }

        // Pre Order Traversal without Recursion
        public List<Integer> preOrderTraversal(TreeNode root){
            List<Integer> resultList = new ArrayList<>();
            Stack<TreeNode> treeStack = new Stack<>();
            if(root == null){
                return resultList;
            }
            treeStack.push(root);
            while(!treeStack.isEmpty()){
                TreeNode tempNode = treeStack.pop();
                if(tempNode != null){
                    resultList.add(tempNode.val); // 访问根结点
                    treeStack.push(tempNode.right); // 右孩子入栈 后出栈
                    treeStack.push(tempNode.left);  // 左孩子入栈 先出栈
                    // 下一次就会 先访问 左节点： 根，右入，左入，（左始终在右上面）
                }
            }
            return resultList;
        }


        // In Order Traversal without Recursion
        // 核心思路，一直找左，找到 最左节点 后，pop出来，放入visited，map（查重）
        // 找到了最左，最后push 右
        public List<Integer> inOrderTraversal(TreeNode root){
            List<Integer> visitedList = new ArrayList<>();
            Map<TreeNode, Integer> visitedNodeMap = new HashMap<>();
            Stack<TreeNode> toBeVisitedNodes = new Stack<>();
            if (root == null) {
                return visitedList;
            }
            toBeVisitedNodes.push(root);
            while (!toBeVisitedNodes.isEmpty()) {
                TreeNode tempNode = toBeVisitedNodes.peek(); // peek() only take a look at the top. won't pop it
                while (tempNode.left != null) { //左节点如果没有被访问过，则先访问左节点
                    if (visitedNodeMap.get(tempNode.left) != null) { // 如果该左节点被访问过了，跳过
                        break;
                    }
                    toBeVisitedNodes.push(tempNode.left); // 将要访问的左节点入栈
                    tempNode = tempNode.left;
                }
                //找到最左，pop出去最左节点
                tempNode = toBeVisitedNodes.pop();
                //记录已找过的节点
                visitedList.add(tempNode.val);
                //查重，防止二次遍历
                visitedNodeMap.put(tempNode, 1);
                //右节点有的话，入栈。（最后遍历的就是右树
                if (tempNode.right != null) {
                    toBeVisitedNodes.push(tempNode.right);
                }
            }
            return visitedList;
        }

        // 改进后的 更高效率中序遍历
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;

            while (curr != null || !stack.empty()) {
                while (curr != null) {
                    stack.add(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
            return list;
        }

        // Post Order Traversal
        public List<Integer> postOrderTraversal(TreeNode root) {
            List<Integer> resultList = new ArrayList<>();
            if (root == null) {
                return resultList;
            }
            Map<TreeNode, Integer> visitedMap = new HashMap<>();
            Stack<TreeNode> toBeVisitedStack = new Stack<>();
            toBeVisitedStack.push(root);
            while (!toBeVisitedStack.isEmpty()) {
                TreeNode tempNode = toBeVisitedStack.peek();
                if (tempNode.left == null && tempNode.right == null) { // 左右节点都空，到了末端点了
                    resultList.add(tempNode.val);
                    visitedMap.put(tempNode, 1);
                    toBeVisitedStack.pop();
                    continue;
                } else if (!((tempNode.left != null && visitedMap.get(tempNode.left) != null) || (tempNode.right != null && visitedMap.get(tempNode.right) != null))) {
                    // 左右孩子都被访问过了
                    resultList.add(tempNode.val );
                    toBeVisitedStack.pop();
                    visitedMap.put(tempNode, 1);
                    continue;
                }
                if (tempNode.left != null) {
                    while (tempNode.left != null && visitedMap.get(tempNode.left) == null) {
                        // 左孩子没有被访问过
                        toBeVisitedStack.push(tempNode.left);
                        tempNode = tempNode.left;
                    }
                }
                if (tempNode.right != null) {
                    while ( visitedMap.get(tempNode.right) == null) {
                        // 右孩子没有被访问过
                        toBeVisitedStack.push(tempNode.right);
                        tempNode = tempNode.right;
                    }
                }
            }
            return resultList;
        }

        // 改进版，用一种类先序的遍历方法得到结果，但是用的是 根 右 左，然后把结果倒置一下，变成 左 右 根
        // Improved post order traversal
        public List<Integer> postOrderTraversalImproved(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            // Double end queue
            // 支持两端插入或者移除元素的collection
            stack.push(root);
            List<Integer> ret = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    ret.add(node.val);
                    stack.push(node.left);
                    stack.push(node.right);
                }
            }
            Collections.reverse(ret);
            return ret;
        }
    }
}

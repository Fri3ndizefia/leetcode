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


        public List<Integer> preorderT(TreeNode root) {
            List<Integer> preOrderList = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    preOrderList.add(root.val); // 根压入栈中
                    root=root.left;
                }
                while (root == null && !stack.isEmpty()) {
                    root = stack.pop().right; // 自底向上找到栈中根节点的第一个非空右孩子。
                }
            }
            return preOrderList;
        }

        public List<Integer> inorderT(TreeNode root){
            List<Integer> inOrderList = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                inOrderList.add(root.val);
                root = root.right;
            }
            return inOrderList;
        }

        // 左右根
        public List<Integer> postorderT(TreeNode root) {
            List<Integer> postOrderList = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.peek();
                if (root.right == null || root.right == pre) {
                    pre = root ;
                    postOrderList.add(stack.pop().val);
                    root = null;
                }else{
                    root = root.right;
                }
            }
            return postOrderList;
        }

        public List<Integer> postorderTTT(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (root != null || !stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    list.add(node.val);
                    stack.push(node.left);
                    stack.push(node.right);
                }
            }
            return list;
        }


        // Pre Order Traversal without Recursion
        // 高效率 前序遍历 非递归
        public List<Integer> preOrderTraversal(TreeNode root){
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> treeStack = new Stack<>();
            if(root == null){
                return list;
            }
            treeStack.push(root);
            while(!treeStack.isEmpty()){
                TreeNode tempNode = treeStack.pop();
                if(tempNode != null){ // 因为可能放入了null 节点进去，要进行排查
                    list.add(tempNode.val); // 访问根结点
                    treeStack.push(tempNode.right); // 右孩子入栈 后出栈
                    treeStack.push(tempNode.left);  // 左孩子入栈 先出栈
                    // 下一次就会 先访问 左节点： 根，右入，左入，（左始终在右上面）
                }
            }
            return list;
        }

        // 改进后的 更高效率中序遍历
        // 高效率 中序遍历 非递归
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;

            while (curr != null || !stack.empty()) {
                /**
                 * 不管什么，先把所有的左节点给push进去，直到没有了
                 * 这样就把左节点全部放进栈中了
                 */
                while (curr != null) {
                    stack.add(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                /**
                 * 弹出左节点开始
                 * 值放入list中。
                 * 下一步是curr的右节点。
                 */
                list.add(curr.val);
                curr = curr.right;
                /**
                 * 再次进入循环的时候，会对右子树的左节点开始进行push
                 * 要注意的是，每次push进去的左节点中是包含了根节点的，所以这里面
                 * 没有对根作特别强调。但是根据list添加的顺序，不难发现是左 根 右的中序遍历。
                 */
            }
            return list;
        }


        public List<Integer> inorder(TreeNode root){
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }

            return list;
        }


        // 改进版，用一种类先序的遍历方法得到结果，但是用的是 根 右 左，然后把结果倒置一下，变成 左 右 根
        // Improved post order traversal
        // 后序遍历 高效率 非递归实现
        // 前序遍历（变种版）reverse 过来即可
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

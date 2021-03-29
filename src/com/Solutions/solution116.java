package com.Solutions;


/**
 *
 */
public class solution116 {
    public Node connect(Node root) {
        if(root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    public void connectTwoNode(Node node1, Node node2){
        if(node1 == null || node2 == null) return;
        node1.next = node2;

        // 连接node1的左和右
        connectTwoNode(node1.left,node1.right);
        // 连接node2的左和右
        connectTwoNode(node2.left, node2.right);
        // 将node1的右和node2的左连起来，跨父连接
        connectTwoNode(node1.right, node2.left);

    }
}

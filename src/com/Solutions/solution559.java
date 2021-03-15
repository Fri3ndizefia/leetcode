package com.Solutions;

/***
 * N叉树的最深处 类似104题
 */
public class solution559 {
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        int ans = 1;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node) + 1);
        }
        return ans;
    }


}

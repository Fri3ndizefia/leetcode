package com.Solutions;

/**
 * 根据中序和后序结果，重新构建二叉树
 */
public class solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; ++i){
            if(rootVal == inorder[i]){
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootIndex - inStart;
        // inorder:      [left] root [right]
        //             iS       rootIndex   iE
        // postorder:    [left] [right]root
        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1 );

        root.right= buildTree(inorder,rootIndex+1,inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}

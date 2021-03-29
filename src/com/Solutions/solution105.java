package com.Solutions;

public class solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build( preorder, 0, preorder.length -1,
                inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd) return null;
        int rootVal = preorder[preStart];

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; ++i){
            if(inorder[i] == rootVal){
                rootIndex = i;
            }
        }

        int leftSize = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex-1);

        // rootIndex 是在 inorder中找的，不能给preorder用
        // 各自用各自的方法算出
        // 其中 preStart的新位置可以用到在inorder中算出来的leftSize帮忙
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd);
        return root;
    }
}

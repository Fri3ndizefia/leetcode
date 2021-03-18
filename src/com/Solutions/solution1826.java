package com.Solutions;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 剑指07 重建二叉树
 * 提供前序遍历和中序遍历，返回一个二叉树
 */

public class solution1826 {
    /**
     * 递归思路：
     *
     * 任何一颗树，根据前序遍历和中序遍历的结果可以划分成
     * [ 根节点, [左子树的遍历结果], [右子树的遍历结果] ]
     * [ [左子树的遍历结果], 根节点，[右子树的遍历结果] ]
     *
     * 在中序遍历中定位到根节点后，就可以知道 左子树 和右子树的 节点数量多少了
     *
     * 构建哈希表可以减少耗时
     */

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;

        // 在中序遍历中把 根节点 找到，这样可以 左右划分 左子树和右子树
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 构建出根节点（子树根节点）
        TreeNode root = new TreeNode(preorder[preorder_root]);

        // 得到左子树的节点数目
        int size_left_subtree = inorder_root - inorder_left;

        // 递归的构造左子树，并连接到根节点
        // 前序遍历中，【从 左边界 + 1 开始的size_left_subtree】个元素就对应了中序遍历中【从左边界开始到根节点定位-1】的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);

        // 递归的构造右子树，并连接到根节点
        // 前序遍历中，【从 左边界+1+左子树节点树木 开始到 右边界】的元素就对应了中序遍历中 【从根节点定位+1 到 右边界】的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    /**
     * 迭代法，记录一下答案
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-by-leetcode-s/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

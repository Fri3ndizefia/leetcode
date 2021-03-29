package com.Solutions;

import java.util.*;

/**
 * DP篇
 * 小偷系列
 */
public class solution337 {

    /**
     * 简化问题思路版
     *        爷爷
     *   儿子1     儿子2
     * 孙1   孙2  孙3  孙4
     *
     * 两种方案，爷爷和孙子们偷钱
     *         儿子们偷钱
     * 不能建立连接关系
     * 爷爷偷的钱就是 root.val
     * 孙子们偷的钱就是 rob(root.left.left) + rob(root.left.right) +
     *              rob(root.right.left) + rob(root.right.right)
     * 儿子偷的钱就是 rob(root.left) + rob(root.right);
     * 爷爷+孙子， 儿子，这两种情况进行比较，选出最大值，就可以得到答案了
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if(root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }


    /**
     * 记忆化Map保存，可以减少重复性质的计算
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);

        int money = root.val;
        if (root.left != null) {
            money += (robInternal(root.left.left, memo)) + (robInternal(root.left.right, memo));
        }
        if (root.right != null) {
            money += (robInternal(root.right.left, memo)) + (robInternal(root.right.right, memo));
        }
        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);
        return result;
    }

    /**
     * 用一个数组表示偷或者不偷
     * 0代表不偷，1代表偷
     * 如果这个节点不偷的话，最大偷钱数 = 左孩子能偷到的钱 + 右孩子能偷到钱
     * 如果这个节点偷的话，最大偷钱数 = 当前节点的偷的钱 + 左孩子不偷钱的钱数 + 右孩子不偷钱的钱数
     * root[0] = max(rob(root.left)[0], rob(root.left)[1]) + max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = root.val + rob(root.left)[0] + rob(root.right)[0]
     */
    public int rob3(TreeNode root) {
        int[] result = robInternal3(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal3(TreeNode root) {
        if(root == null) return new int[2];
        int[] result = new int[2];
        int[] left = robInternal3(root.left);
        int[] right = robInternal3(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}

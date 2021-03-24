package com.Solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 剑指 54
 * 二叉搜索树中的第k大节点
 *
 * 二叉搜索数的中序遍历下来是一个递增的数组
 * 如果将二叉搜索的中序遍历倒序就是一个递减数组
 * 中序：左 根 右
 * 中序倒转：右 根 左
 *
 * 第k大就可以是中序遍历（逆）的提前返回。
 * 右 根 左的顺序，当遍历到k就可以返回了。
 *
 */

public class solution1883 {

    /**
     * 递归解析：
     *  1、终止的条件， k == 0
     *  2、递归右子树，dfs（root.right）
     *  3、三项工作：
     *      1。提前返回 k == 0
     *      2。统计序号，执行 k = k - 1
     *      3。记录结果 若 k == 0，记录 res = root.val
 *      4、递归左子树 dfs（root.left）
     *
     * @param root
     * @param k
     * @return
     */
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfsReverse(root);
        return res;
    }

    /**
     * 中序遍历逆序
     * @param root
     */
    void dfsReverse(TreeNode root){
        if (root == null) {
            return;
        }
        dfsReverse(root.right);
        if(k == 0 ) return;
        if(--k == 0) {
            res = root.val;
            return;
        }
        dfsReverse(root.left);
    }

}

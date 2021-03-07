package com.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 两颗二叉搜索树的全部元素
 *
 * 简单思路 先遍历 后排序，最后输出即可
 *
 */
public class solution1305 {
    private List<Integer> list;

    private void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(list);
        return list;

    }

}

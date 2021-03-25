package com.Solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * DFS篇
 * 子集类
 * 返回子集
 */
public class solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, nums, res, path);
        return res;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> res, Deque<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; ++i) {
            path.addLast(nums[i]);
            dfs(i + 1, nums, res, path);
            path.pollLast();
        }
    }
}

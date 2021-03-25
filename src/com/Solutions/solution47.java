package com.Solutions;

import java.util.*;

/**
 * DFS篇
 * 全排序类
 * 47 全排列2
 * 给定的序列是可以有重复数字的
 */
public class solution47 {

    /**
     * 使用哈希集合是利用到了Java的集合的特性
     */
    Set<List<Integer>> hashSet = new HashSet<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, boolean[] used,
                    List<Integer> path, List<List<Integer>> res) {
        if(depth == len){
            if (hashSet.add(path)) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = 0; i < len; ++i) {
            if(!used[i]){
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth + 1, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 运用剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique_jianzhi(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>(len);

        // 无论升序还是降序，排序是剪枝的关键
        // 这样可以确保重复的元素在相邻隔着
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        dfs_jianzhi(nums, len, 0, used, path, res);
        return res;
    }

    public void dfs_jianzhi(int[] nums, int len, int depth, boolean[] used,
                            Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            // 如果被用过了，跳
            if (used[i]) {
                continue;
            }
            /**
             * 剪枝叶的条件 i>0 保证 i-1 的地方有意义
             * 写 !used[i-1] 是因为 nums[i-1]在深度优先遍历中刚刚被撤销选择
             */
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs_jianzhi(nums, len, depth + 1, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }

}

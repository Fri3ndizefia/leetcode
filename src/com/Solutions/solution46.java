package com.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DFS篇目
 * 46 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的序列.
 */
public class solution46 {
    /**
     * 回溯
     * 回溯采用试错的思想，尝试分步的去解决一个问题。在分步解决问题的过程中， 当它通过尝试
     * 发现现用的分步答案不能得到有效的正确的解答的时候，就会取消上一步甚至是上所有步的操作，
     * 再通过其他的可能解法再次尝试寻找问题的答案。
     *
     * DFS
     * 深度优先算法是一种用于遍历或搜索树或者图的算法。这个算法会尽可能深的搜索树的分支。
     * 当节点v所在边都已经被探寻过，搜索将回溯到发现节点v的那条边的起始节点。
     *
     * 回溯讲究的是一种 破坏现场+得出结果+还原现场的过程
     * 这里的回溯法，首先将自己作为副本保存入一个数组中
     * 每次递归的时候 first 位置和 i 进行互换（
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);//自身
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
            // Java中的参数传递是值传递，对象类型变量在传参的时候，复制的是变量的地址。这些地址
            // 被添加到res变量，但实际上指向的是同一块内存地址。
            // 做一次拷贝就留下自己真正想要的数据.
        }
        for (int i = first; i < n; ++i) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, i, first);

        }
    }
    /**
     * 如果 output那边，传进来的是new 出来的对象，就可以不用回溯，也就是不用恢复现场
     * 但是这样会消耗大量的内存空间
     * 回溯也是一种节省空间的用法
     * 所以不回溯也是可以的，候选数比较多的时候，在非叶子节点上创建新的状态变量的性能消耗就很严重
     * 就这道题而言，只需要叶子节点的那个状态，在叶子节点执行拷贝，时间复杂度是N，路径变量在深度
     * 优先遍历的时候，节点之间的转换只需要 1
     *
     * 最后，由于回溯算法时间复杂度很高，当遍历到已经不满足或者提前知道了这一条分支的结果不符合的
     * 时候，就可以提前返回结束。称之为 剪枝
     */
    /**
     * 剪枝
     * 通过剪枝提高搜索速度，提前返回进行回溯。
     */

    public List<List<Integer>> permute2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth,
                    List<Integer> path, boolean[] used,
                    List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                //进行分支路线的寻找答案
                dfs(nums, len, depth + 1, path, used, res);
                //进行回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

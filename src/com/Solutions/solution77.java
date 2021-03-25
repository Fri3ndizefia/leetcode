package com.Solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * DFS篇
 * 组合类
 * 1到n中，k个整数可以组成的组合
 */
public class solution77 {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combinations = new ArrayList<>();
        if (k <= 0 || n < k) {
            return combinations;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, combinations);
        return combinations;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> combinations) {
        if (path.size() == k) {
            combinations.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能出现的搜索起点
        // 选择的上界其实是 n - k + 1，超过这个上界都是无意义的遍历
        // k就像是随着遍历会减少 k = k-path.size（），要注意k代表的是接下来要遍历的个数。
        // 加一个条件可以进行优化剪枝
        // i <= n-(k-path.size()) + 1;
        for (int i = begin; i <= n; ++i) {
            // 添加元素
            path.addLast(i);
            // 由于不允许重复，所以从下一个数字开始作为遍历
            // 注意是 begin = i + 1
            // 当前for循环中的 i ，大一位数的值
            dfs(n, k, i + 1, path, combinations);
            path.pollLast();
        }
    }
}

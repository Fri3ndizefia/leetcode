package com.Solutions;

import java.util.*;

/**
 * 吃橘子问题
 * 处理整数直到整数为0
 * 一种操作：整数-1
 * 操作2：偶数，可除2
 * 操作3：3倍数，可除3
 */
public class solution1553 {

    /**
     * 数学方法，同时使用了Map进行记忆。
     */
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int minDays(int n) {
        if(n <=1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        memo.put(n, Math.min(n % 2 + 1 + minDays(n/2), n % 3 + 1 + minDays(n/3)));
        return memo.get(n);
    }


    /**
     * 搜索式算法
     * dijkstra算法求答案
     * 转换思想
     * 图 GG 中有若干个节点，每个节点表示着一个数。根据方法一，每个节点对应着一个 \lfloor n/(2^x3^y) \rfloor⌊n/(2
     * x
     *  3
     * y
     *  )⌋，节点数为 O(\log^2 n)O(log
     * 2
     *  n)；
     *
     * 图 GG 中有若干条有向边，如果某个节点表示的数为 ii，那么 ii 到 \lfloor i/2 \rfloor⌊i/2⌋ 有一条长度为 i\%2 + 1i%2+1 的有向边，ii 到 \lfloor i/3 \rfloor⌊i/3⌋ 有一条长度为 i\%3 + 1i%3+1 的有向边。边数同样为 O(\log^2 n)O(log
     * 2
     *  n)；
     *
     * 我们需要求出 nn 对应的节点到 11 对应的节点的最短路径的长度。
     */

    public int minDays2(int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] daysRest1, int[] daysRest2) {
                if (daysRest1[0] != daysRest2[0]) {
                    return daysRest1[0] - daysRest2[0];
                } else {
                    return daysRest1[1] - daysRest2[1];
                }
            }
        });
        Set<Integer> visited = new HashSet<Integer>();
        queue.offer(new int[]{0, n});
        int ans = 0;
        while (true) {
            int[] daysRest = queue.poll();
            int days = daysRest[0], rest = daysRest[1];
            if (visited.contains(rest)) {
                continue;
            }
            visited.add(rest);
            if (rest == 1) {
                ans = days + 1;
                break;
            }
            queue.offer(new int[]{days + rest % 2 + 1, rest / 2});
            queue.offer(new int[]{days + rest % 3 + 1, rest / 3});
        }
        return ans;
    }
}

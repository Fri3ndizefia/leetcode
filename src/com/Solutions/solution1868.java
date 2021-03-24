package com.Solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 40
 * 最小的k个数
 *
 * Top K 问题之： 最小的K个数问题
 */
public class solution1868 {
    /**
     * 优先队列实现最小堆
     * 设置优先队列的容量，每次遇到新的更小值就会把大的给踢掉
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastK(int[] arr, int k) {
        if(k == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i : arr) {
            queue.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 排序方法
     * 时间复杂度 NlogN
     * 空间复杂度 logN
     * 排序后直接取出前k个数即可
     */
    public int[] getLeastK1(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }


}

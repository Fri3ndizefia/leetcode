package com.Solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class solution1642 {

    /**
     * 贪心策略
     * 优先使用梯子，梯子不够的时候取出差值最小的，出堆，用砖块垫着。
     * 砖块数量也不够了，就出栈了吧
     * @param heights
     * @param bricks
     * @param ladders
     * @return
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < heights.length; ++i) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                queue.offer(diff);
                if (queue.size() > ladders) {
                    sum += queue.poll();
                }
                if (sum > bricks) {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }

}

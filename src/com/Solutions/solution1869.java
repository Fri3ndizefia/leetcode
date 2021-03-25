package com.Solutions;

import java.util.*;

/**
 * 剑指 41
 * 数据流中的中位数
 */

public class solution1869 {

    Queue<Integer> A,B;

    /**
     * 左手一个小顶堆，右手一个大顶堆。
     * 完美解决问题
     */
    public solution1869() {
        A = new PriorityQueue<>(); // 默认小顶堆 保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); //默认大顶堆 保存较小的一半
    }

    public double solution1869() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            /**
             * A比B大，A是小顶堆，为了让A始终存放较大的数值
             * 通过A来排序得到最小值，然后poll出去给B吃
             * 这个操作第一步只是利用了A的 小顶堆 的性质
             */
            A.add(num);
            B.add(A.poll());
        }else{
            /**
             * A和B相同大小了，通过B的性质，把最大的值给A
             * 同样是利用B的 大顶堆的性质，将较大的值塞给了A
             */
            B.add(num);
            A.add(B.poll());
        }
    }
}

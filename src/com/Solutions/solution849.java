package com.Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书馆找位置，
 * 距离最近的人的位置的最大值
 */

public class solution849 {
    public int max(int[] seats) {
        List<Integer> list = new ArrayList<>(); // 保存了索引
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);
            }
        }
        System.out.println(list);
        int dist = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            dist = Math.max(dist, (list.get(i + 1) - list.get(i)) / 2);
            System.out.println(dist);
        }
        dist = Math.max(dist, Math.max(list.get(0), seats.length - 1 - list.get(list.size() - 1)));
        return dist;
    }

    public int max2(int[] seats) {
        int prev = -1;
        int max = 1;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (prev >= 0) {
                    max = Math.max((i - prev) / 2, max);
                }else{
                    max = i;
                }
                prev = i;
            }
        }

        max = Math.max((seats.length - 1) - prev, max);
        return max;
    }

    public static void main(String[] args) {
        solution849 test = new solution849();

        test.max(new int[]{1, 0, 0, 0, 1, 0, 1});
    }
}

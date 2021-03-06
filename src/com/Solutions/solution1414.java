package com.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 贪心算法
 * 斐波那契最少数量获取和是一个指定数
 */

public class solution1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(a, b));
        while(a + b <= k){
            list.add(a+b);
            int temp = b;
            b = a + b;
            a = temp;
        }
        int ans = 0;
        int i = list.size() - 1;
        do {
            if (k - list.get(i)>= 0) {
                k = k - list.get(i);
                ans ++;
            }
            i--;
        } while(k!=0);
        return ans;
    }
}

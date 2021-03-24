package com.Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 *
 */

public class solution1889 {

    /**
     * 利用数学表达式
     * sum = (l + r) * ( r - l + 1) / 2
     * 得到从l到r的连续整数的和。
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (r + l) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                ++l;
            } else if (sum < target) {
                ++r;
            }else{
                ++l;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

}

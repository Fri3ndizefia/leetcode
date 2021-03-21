package com.Solutions;

/**
 * 最多可以把 K 个 0 变成1， 求仅包含1的最长子数组的长度
 * 转换=》找出一个最长的子数组，最多允许有K个0
 *
 * 滑动窗口思想
 */
public class solution1004 {

    /**
     * 滑动窗口
     *
     * ********************************
     * 滑动窗口模版：
     * 以右指针作为驱动，拖着左指针向前走。右指针每次只移动一步，而左指针在内部while 循环中每次
     * 可能移动多步。右指针是主动前移，探索未知的区域。
     * 左指针是被迫移动，负责寻找满足题意的区间。
     * ********************************
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (A[right] == 0) {
                ++zeros;
            }
            while (zeros > K) {
                if (A[left++] == 0) {
                    --zeros;
                }
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }
}

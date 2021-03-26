package com.Solutions;


/**
 * 合并两个有序数组
 * A数组有足够大的空间让B合并进来
 */
public class solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else if (n == 0) {
            return;
        }

        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; --i) {
            if(index1 == -1) {
                nums1[i] = nums2[index2--];
            } else if (index2 == -1) {
                nums1[i] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1];
                --index1;
            } else {
                nums1[i] = nums2[index2];
                --index2;
            }
        }

        /**
         * 优化
         */
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
            // 相等的情况也考虑nums1，nums1最先用完
            // p1可能是最快结束的
        }

        // 最后可能将 p2 的可能丢失的值拿进来
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}

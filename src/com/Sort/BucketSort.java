package com.Sort;

import java.util.Collections;
import java.util.Vector;

/**
 * 分桶
 * [0-9] [10-19] [20-29]...
 * 把对应的数字再放进去，再排序，即可
 */
public class BucketSort {

    public static void bucketSort(float[] array) {
        if (array.length <=0) {
            return;
        }

        int n = array.length;

        /**
         * 1) Create n empty buckets
         */
        Vector<Float>[] buckets = new Vector[n];
        for (int i = 0; i < n; ++i) {
            buckets[i] = new Vector<Float>();
        } //类似二维？

        /**
         * 2) Put every element into different buckets
         */
        for (int i = 0; i < n; ++i) {
            int idx = (int) array[i] * n;
            buckets[idx].add(array[i]);
        }

        /**
         * 3) Sort every bucket
         */
        for (int i = 0; i < n; ++i) {
            Collections.sort(buckets[i]);
        }

        /**
         * 4) Concatenate all buckets
         */
        int index = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < buckets[i].size(); ++j) {
                array[index++] = buckets[i].get(j);
            }
        }
    }


}

package Algorithms.Sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] A = CountingSort.countingSort(new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1});
        System.out.println(Arrays.toString(A));
    }

    public static int[] countingSort(int[] A) {
        int[] B = new int[A.length];
        int k = 100; //假定是 <= 100
        countingSort(A, B, k);
        return B;
    }

    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        // counting
        for(int i: A) C[i]++;
        // sum of counting
        for (int i = 1; i < k; ++i) C[i] = C[i] + C[i - 1];
        // sort
        for (int j = A.length - 1; j >= 0; --j) {
            B[C[A[j]] - 1 ] = A[j]; // 值-1 得新索引
        }
    }


}

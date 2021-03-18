package com.Solutions;

public class solution775 {
    public boolean isIdealPermutation(int[] A) {
        int global = 0;
        int local = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i + 1]) {
                ++local;
            }
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[i]) {
                    ++global;
                }
            }
        }
        return global==local;
    }

    public boolean rememberedSmallestNumber(int[] A) {
        int N = A.length;
        int floor = N;
        for (int i = N - 1; i >= 2; --i) {
            floor = Math.min(floor, A[i]);
            if(A[i-2]> floor) return false;
        }
        return true;
    }
}

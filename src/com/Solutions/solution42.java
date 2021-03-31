package com.Solutions;

/**
 * 接雨水问题
 */
public class solution42 {
    /**
     * 暴力法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        // 第一格 接不到水，最后一格也接不到水
        for(int i = 1; i < n-1; ++i){
            int left_max = 0;
            int right_max = 0;
            for(int j = 0; j <= i ;++j){
                if(height[j] > left_max){
                    left_max = height[j];
                }
            }
            for(int j = i; j < n;++j){
                if(height[j] > right_max){
                    right_max = height[j];
                }
            }
            res += Math.min(left_max, right_max) - height[i];
        }
        return res;
    }

    /**
     * 备忘录法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n  = height.length;
        if(n == 0) return 0;
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        // 基本初始化
        left[0] = height[0];
        right[n-1] = height[n-1];

        //从左到右，找到左边的最大值
        for (int i = 1; i < n; ++i) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        //从右到左，找到右边的最大值
        for (int i = n - 2; i >= 0; --i) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 1; i < n-1; ++i) {
            res += Math.min(left[i], right[i]) - height[i];
        }

        return res;
    }


}

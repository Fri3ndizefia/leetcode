package com.Solutions;

import java.util.Arrays;

/***
 * 可构建几个三角形？
 *
 */
public class solution611 {
    /***
     * 无脑枚举法
     * 时间复杂度 O(N^3)
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] <= nums[k] || nums[i] + nums[k] <= nums[j] || nums[j] + nums[k] <= nums[i]) {
                        continue;
                    }else{
                        ans++;
                    }
                }
            }
        }
        return 0;
    }

    /***
     * 排序后 二分查找法，排序后，必定会  a <= b <= c
     * 一旦满足  a + b > c 即可满足题意
     * 时间复杂度是 n^2logn
     */
    public int triangleNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0 ;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int sum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int mid = left + right + 1 >>> 1; // 数字 >>> 1  就是 [n/2] 向下取整
                    // left + right + 1 >>> 1 获得到了 中点
                    if (nums[mid] < sum) {
                        left = mid;
                    } else right = mid - 1;
                }
                if (nums[right] < sum) {
                    ans += right - j;
                }
            }
        }
        return ans;
    }


    /***
     * 双指针法
     * 先排序，然后固定最长边，双指针，一个指针从左开始，一个指针从右开始。
     * 如果 nums[l] + nums[r] > nums[i]，同时说明 nums[l + 1] + nums[r] > nums[i], ..., nums[r - 1] + nums[r] > nums[i]，满足的条件的有 r - l 种，r 左移进入下一轮。
     * 如果 nums[l] + nums[r] <= nums[i]，l 右移进入下一轮。
     *
     * 找到一个左边即可满足的指针，那么接下来左指针到右指针这区间的所有数都可以满足，减少计算量，左移右指针
     * 找到一个左边未能满足的指针，那么接下来左指针要右移，直到发现⬆
     */
    public static int triangleNumberFinding(int[] nums){
        int n = nums.length;
        int ans = 0;
        for (int i = n - 1; i >= 2; --i) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left ++;
                }
            }
        }
        return ans;

    }

}

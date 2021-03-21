package com.Solutions;


/**
 * 查找数字的位置或者应该插入的位置
 */
public class solution35 {
    public int find(int[] nums, int target) {
        int preIndex = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                ++preIndex;
            } else {
                break;
            }
        }
        return preIndex+1;
    }

    /**
     * 在一个有序数组中找第一个大于等于 \textit{target}target 的下标
     * 使用了二分查找的思想。
     *
     * 返回 l 即可。要么l就是查找到的位置， 要么l就是要插入的位置
     * @param nums
     * @param target
     * @return
     */
    public int find2(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n -1;
        while (l <= r) {
            int mid = (l+r) >>> 1;
            if (nums[mid] < target) {
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}

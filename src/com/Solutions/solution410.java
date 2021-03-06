package com.Solutions;


public class solution410 {

    public int splitArray(int[] nums, int m){
        if (nums == null || nums.length == 0 || m == 0)
        {
            return 0;
        }
        long left = 0, right = 0;
        // left = max(nums);
        // right = sum(nums);
        for ( int i : nums )
        {
            left = Math.max(left, i);
            right += i;
        }
        while(left < right){
            long mid = left + (right - left )/2;
            int tmp = 0, count = 1;
            for( int i : nums )
            {
                tmp += i;
                if ( tmp > mid){
                    tmp = i;
                    count ++;
                }
            }
            if ( count > m){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int)left;
    }

}

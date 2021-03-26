package com.Solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 是否有重复的数？
 */

public class solution217 {
    /**
     * 集合快速解决
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums){
            if(!set.add(i)) return true;
        }
        return false;
    }



}

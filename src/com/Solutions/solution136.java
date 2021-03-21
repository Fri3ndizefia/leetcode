package com.Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找出只出现一次的数字
 */
public class solution136 {

    /**
     * 超慢做法，哈希表
     * @param nums
     * @return
     */
    public int single(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            }else{
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        for (int i : map.keySet()) {
            return i;
        }
        return -1;
    }

    /**
     * 更快的 HashSet做法，因为Set不能有重复元素
     * 当添加重复元素会返回false，这个时候将它remove掉
     * 不会返回false就是唯一剩下的单一元素了
     * @param nums
     * @return
     */
    public int single2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        return set.iterator().next();
    }


    /**
     * https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * 推导过程 ⬆️
     *
     * 要注意的是，通过异或运算，可以最终确定得到唯一一个只出现一次的数字。
     * @param nums
     * @return
     */
    public int single3(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }

}

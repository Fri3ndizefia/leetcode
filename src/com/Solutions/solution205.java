package com.Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断同构与否
 * egg 可以 pdd 同构
 * paper 和 title
 */

public class solution205 {
    /**
     * 单哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == t.charAt(i)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    /**
     * 用数组来解决
     */
    public boolean isIsomorphocByArray(String s, String t){
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] indexOfS = new int[256];
        int[] indexOfT = new int[256];
        for (int i = 0; i < chars.length; ++i) {
            if (indexOfT[chart[i]] != indexOfS[chars[i]]) {
                return false;
            }
            indexOfS[chars[i]] = i + 1;
            indexOfT[chart[i]] = i + 1;
        }

        return true;
    }
}

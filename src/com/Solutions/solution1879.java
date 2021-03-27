package com.Solutions;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 50
 *
 * 第一次只出现一次的字符
 */
public class solution1879 {

    /**
     * 调用 LinkedHashMap
     * @param s
     * @return
     */
    public char firstUniq(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniq2(String s) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            ++table[c-'a'];
        }
        for (char c : s.toCharArray()) {
            if (table[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}

package com.Solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * DFS篇
 * 全排序类
 * 面试题 08-07- 无重复字符串的排列组合
 */

public class solution1950 {

    /**
     * 经典老题老解
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        Deque<String> queue = new ArrayDeque<String>();
        int len = s.length();
        if (len == 0) {
            return new String[]{""};
        }
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[len];
        StringBuilder sb = new StringBuilder(len);
        dfs(chars, len, 0, used, sb, queue);
        String[] result = new String[queue.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = queue.poll();
        }
        return result;
    }

    public void dfs(char[] chars, int len, int depth, boolean[] used,
                    StringBuilder sb, Deque<String> queue) {
        if (depth == len) {
            queue.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (!used[i]) {
                used[i] = true;
                sb.append(chars[i]);
                dfs(chars, len, depth + 1, used, sb, queue);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    /**
     * 交换法实现全排列
     * @param s
     * @return
     */
    public String[] permutation2(String s) {
        List<String> list = new ArrayList<>();
        list.add(s);
        for (int i = 0; i < s.length() - 1; ++i) {
            int size = list.size();
            for (int j = i + 1; j < s.length(); ++j) {
                for (int index = 0; index < size; ++index) {
                    list.add(swap(list.get(index), i, j));
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * 异或法实现两数交换
     * a ^= b -> a = a^b
     * b ^= a -> b = b^(a^b) = b^b^a = a
     * a ^= b -> a = a^b ^a = b
     * 不用借助第三个数
     * @param s
     * @param pos1
     * @param pos2
     * @return
     */
    private String swap(String s, int pos1, int pos2) {
        char[] chars = s.toCharArray();
        chars[pos1] ^= chars[pos2];
        chars[pos2] ^= chars[pos1];
        chars[pos1] ^= chars[pos2];
        return new String(chars);
    }


}

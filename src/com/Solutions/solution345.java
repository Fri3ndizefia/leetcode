package com.Solutions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转字符串中的元音字母
 *
 * set保存
 * 双指针遍历
 * 遍历到了则交换保存
 */

public class solution345 {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    ));
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int low =0 ;
        int high = s.length() - 1;
        char[] c = s.toCharArray();
        while (low <= high) {
            if (!vowels.contains(c[low])) {
                ++low;
            } else if (!vowels.contains(c[high])) {
                --high;
            } else{
                c[low] ^= c[high];
                c[high] ^= c[low];
                c[low++] ^= c[high--];
            }
        }
        return new String(c);
    }
}

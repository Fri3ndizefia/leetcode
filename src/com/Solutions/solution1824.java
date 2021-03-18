package com.Solutions;

/**
 * 剑指05 替换空格
 */

public class solution1824 {
    public String replaceSpace(String s) {
        StringBuffer string = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                string.append("%20");
            }else{
                string.append(c);
            }
        }
        return string.toString();
    }
}

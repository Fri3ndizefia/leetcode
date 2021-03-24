package com.Solutions;

/**
 * 左旋转字符串
 * 切片
 * 列表
 * 字符串
 */

public class solution1891 {

    /**
     * 切片函数的调用
     * @param s
     * @param n
     * @return
     */
    public String reverse(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * 列表添加
     * @param s
     * @param n
     * @return
     */
    public String reverse2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); ++i) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverse3(String s, int n) {
        String res ="";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }
}

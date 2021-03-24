package com.Solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转单词顺序
 */
public class solution1890 {

    /**
     * 自己的笨方法
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
            if (c == ' ' && sb.length() != 0) {
                deque.push(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length() != 0) sb.append(' ');
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
            sb.append(' ');
        }
        if(sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
        return sb.length() == 0 ? "":sb.toString();
    }

    /**
     * 双指针 反向遍历
     * 第一步删除掉字符串首尾多余的空格
     * 第二步双指针都从 s.length（）-1开始，i往左移动，j不变
     * 当i遇到一个空格的时候，将 i+1，j 范围内的（也就是字符串）保存起来
     * 当i遇到越界的情况的时候，同理
     * 这样就是逆序保存到所有合格的字符串了。
     * 输出即可
     */
    public String reverse(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            // 从最右边开始，遍历，直到找到 空格 字符串 这里位置
            // 这里的i指向了空格，j在字符串的最后一个位置
            while (i >= 0 && s.charAt(i) != ' ') {
                --i;
            }
            //注意 substring的右边界，是开括号，不是闭括号，需要加一
            sb.append(s, i + 1, j + 1).append(" ");
            // 跳过单词的与单词之间的每个空格， 直到寻找到下一个新的单词
            // 此时 i 就指向了一个新的单词的最右边，
            while (i >= 0 && s.charAt(i) == ' ') {
                --i;
            }
            // i拖着j过来，j成为下一个新单词的最右边指针
            j = i;
        }
        return sb.toString().trim();
    }

    /**
     * 分割后倒序输出。
     * 注意方法的使用情况。
     * @param s
     * @return
     */
    public String reverse2(String s) {
        String[] strs = s.trim().split("  ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; --i) {
            if(strs[i].equals("")) continue;
            res.append(strs[i] + " ");
        }
        return res.toString().trim();
    }
}

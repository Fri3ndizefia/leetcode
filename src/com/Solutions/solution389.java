package com.Solutions;

/**
 * 找 两个 字符串的不同处
 * 在第一个字符串随机重排的基础上，随机位置添加了一个字母，找出它
 */
public class solution389 {

    /**
     * 计数
     *
     * 巧妙想到字母对应26个，可以用数字的下标来计数
     * 这样可以在t的检验中，发现被多 减去 的字母对应的下标
     * 此时就可以返回重复的多添加的元素了
     * @param s
     * @param t
     * @return
     */
    public char find(String s, String t) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++array[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < t.length(); ++i) {
            --array[t.charAt(i) - 'a'];
            if (array[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 求和
     *
     * 字符串s的全部字符ascii加起来
     * 字符串t的全部字符ascii加起来
     * t的减去s
     * 就是多出来的重复那个字符，得出结果
     * @param s
     * @param t
     * @return
     */
    public char find2(String s, String t) {
        int as = 0;
        int at = 0;
        for (char c : s.toCharArray()) {
            as += c;
        }
        for (char c : t.toCharArray()) {
            at += c;
        }
        return (char)(at-as);
    }


    /**
     * 联动solution136
     * 位运算可以找到唯一一个"不重复的"值
     * 这里只要将两个字符串拼接起来，通过异或找到 奇数次 出现的字符即可
     * @param s
     * @param t
     * @return
     */
    public char find3(String s, String t) {
        int ret = 0;
        for (char c : s.toCharArray()) {
            ret ^= c;
        }
        for (char c : t.toCharArray()) {
            ret ^= c;
        }
        return (char) ret;
    }

}

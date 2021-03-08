package com.Solutions;

/**
 * 字符串转换小写字母
 */
public class solution709 {
    public String toLowerCase(String str) {
        String newStr = new String();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= 65) {
                newStr += (char)(str.charAt(i) + 32);
            }else newStr += str.charAt(i);
        }
        return newStr;
    }

    /**
     * 用位运算的技巧：
     *
     * 大写变小写、小写变大写：字符 ^= 32;
     * 大写变小写、小写变小写：字符 |= 32;
     * 大写变大写、小写变大写：字符 &= 33;
     */

    public String toLowerCase1(String str){
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            chars[i] |= 32;
        }
        return String.valueOf(chars);
    }
}

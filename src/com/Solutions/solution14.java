package com.Solutions;

/**
 * 14 最长公共前缀
 *
 */
public class solution14 {
    public String longestCommon(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); ++i) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    return sb.length() == 0 ? "" : sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }


    /**
     * 纵向扫描
     * @param strs
     * @return
     */
    public String longestCommon2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; ++i) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < count; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * 横向比较。
     * 根据每一次比较更新公共最长和的字符串。
     * @param strs
     * @return
     */
    public String longestCommon3(String[] strs) {
        if (strs == null | strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; ++i) {
            prefix = longestCommon3(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommon3(String str1, String str2) {
        int length = Math.max(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            ++index;
        }
        return str1.substring(0, index);
    }
}

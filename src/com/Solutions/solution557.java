package com.Solutions;

public class solution557 {
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (String string : s.split(" ")) {
            sb.append(reverseString(string));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String reverseString(String s) {
        StringBuilder copy = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            copy.append(s.charAt(s.length() -1 - i));
        }
        return copy.toString();
    }
}

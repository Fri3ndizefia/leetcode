package com.MianShiQuestions;

import java.io.*;

/**
 * 字符串 根据规则重改
 * AAA -> AA
 * AABB -> AAB 删除第一个B
 */

public class ByteDance_ZJ18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            StringBuilder s = new StringBuilder(str);
            for (int i = 0; i + 2 < s.length(); ++i) {
                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
                if( a == b && b == c) s.deleteCharAt(i--); // i-- 是个重要点
            }
            for (int i = 0; i + 3 < s.length(); ++i) {
                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2), d = s.charAt(i + 3);
                if( a == b && b == c) s.deleteCharAt(i + 2);
            }
            System.out.println(s);
        }
    }
}
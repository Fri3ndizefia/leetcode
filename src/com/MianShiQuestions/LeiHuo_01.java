package com.MianShiQuestions;

import java.io.*;
import java.util.*;

public class LeiHuo_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length() <= 1){
            System.out.println(0);
            return;
        }else if(huiwen(str)){
            System.out.println(0);
            return;
        }
        List<Character> list = new ArrayList<Character>();
        for(char c : str.toCharArray()) list.add(c);
        if(str.length() % 2 == 0) System.out.println(1);
        else System.out.println(2);
    }

    private static boolean huiwen(String s) {
        for (int i = 0; i < s.length() >> 1; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

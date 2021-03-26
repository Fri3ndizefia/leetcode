package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 回文与否
 */
public class Vivo_2 {
    private static boolean huiwen(String s) {
        for (int i = 0; i < s.length() >> 1; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length(); ++i) {
            String test = input.substring(0, i) + input.substring(i + 1);
            if (huiwen(test)) {
                System.out.println(test);
                return;
            }
        }
        System.out.println(false);
    }
}

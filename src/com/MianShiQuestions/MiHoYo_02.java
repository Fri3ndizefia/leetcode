package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiHoYo_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int i,j;
        String[] input = string.split(" ");
        i = Integer.parseInt(input[0]);
        j = Integer.parseInt(input[1]);
        int sum = 0;
        for (int k = i; k <= j; ++k) {
            if (balance(k)) {
                ++sum;
            }
        }
        System.out.println(sum);
    }

    public static boolean balance(int k) {
        int copy = k;
        int digits = 0;
        while (copy != 0) {
            copy /= 10;
            ++digits;
        }
        int oddSum = 0;
        int evenSum = 0;
        boolean oddFirst = digits % 2 == 1;

        for (int i = 0; i < digits; ++i) {
            if (oddFirst && i % 2 == 0) {
                // oddSum
                oddSum += k%10;
            } else if (oddFirst) {
                // evenSum
                evenSum += k%10;
            } else if (i % 2 == 0) {
                evenSum += k % 10;
            } else {
                oddSum += k % 10;
            }
            k/=10;
        }
        return evenSum == oddSum;
    }

}

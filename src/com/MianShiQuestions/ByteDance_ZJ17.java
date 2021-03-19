package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 判断水仙花
 *
 * 我觉得难点在于用那个傻逼编译器去处理符合他格式的代码
 *
 * 100-1000的水仙花数列表 {153,370,371,407}
 *
 */
public class ByteDance_ZJ17 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sxhs = {153, 370, 371, 407};
        String str;
        String[] strs;
        StringBuilder builder = new StringBuilder();
        int m,n;
        boolean flag;
        while((str = br.readLine()) != null){
            flag = false;
            strs = str.split(" ");
            m = Integer.parseInt(strs[0]);
            n = Integer.parseInt(strs[1]);

            for (int i = 0; i < 4; i++) {
                if (m <= sxhs[i] && sxhs[i] <= n) {
                    builder.append(sxhs[i]).append(" ");
                    flag = true;
                }
            }
            if (flag) {
                builder.append("\n");
            }else{
                builder.append("no\n");
            }
        }
        System.out.print(builder.toString());
    }

    private static boolean yes(int num){
        int res = 0;
        int copy = num;
        while(num != 0){
            res += (int) Math.pow(num % 10,3);
            num /= 10;
        }
        return res == copy;
    }
}

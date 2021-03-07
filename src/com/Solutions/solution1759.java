package com.Solutions;

/**
 * 同构子字符串的数目
 * aaa 有 a（3个） + aa （2个） + aaa，共6个
 * 符合规则 n*(n+1)/2
 */
public class solution1759 {
    public int conutHomogenous(String s) {
        long sum = 0;
        long counter = 1;
        Character prev = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == prev) {
                counter ++;
            }else{
                sum += counter*(counter+1)/2; //公式利用，注意counter越界情况，使用long
                counter = 1;
            }
            prev = s.charAt(i);
        }
        sum += counter*(counter+1)/2; // 结算最后一个

        sum %= 1000000007;
        return (int) sum;
    }

    /**
     *
     */
}

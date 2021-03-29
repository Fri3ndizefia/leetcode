package com.Solutions;


/**
 * 回文 子串
 */
public class solution647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        /**
         * 状态 dp[i][j] 表示 区间 [i,j]的子串是不是回文串
         * 状态转移方程
         * dp[i][j] = true, when s[i] == s[j] && ( j - i < 2 || dp[i+1][j-1])
         * 比如说 ababa ， s[i] == s[j] 满足了，判断后面条件 dp[i+1][j-]1，也就是 bab 子串，如果bab是回文，那么ababa也是回文
         * 同样 a 的情况， i-j < 2。所以它自己就是回文
         *   aa 的情况 i-j < 2 ，也是回文。也满足s[i] == s[j]
         *   每出现一次回文，保存一下即可。
         */
        int ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            for (int i = 0; i <= j; ++i) {
                if (s.charAt(i) == s.charAt(j) && (j - 1 < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ++ans;
                }
            }
        }
        return ans;
    }


    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public int countSubStrings2(String s) {
        int answ = 0 ;
        for (int center = 0; center < 2 * s.length() - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ++answ;
                --left;
                ++right;
            }
        }
        return answ;
    }

}

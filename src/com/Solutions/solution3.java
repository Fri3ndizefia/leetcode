package com.Solutions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*
Given a string s, find the length of the longest substring without repeating characters.

02/Mar/2021
 */

public class solution3 {
    // 使用哈希集合 sliding window
    public int usingHashSet(String s){
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();

        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i){
            if ( i != 0){
                occ.remove(s.charAt(i - 1));
            }
            while ( rk + 1 < n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk +1));
                ++rk;
            }

            ans = Math.max(ans, rk-i+1);

        }
        return ans;
    }

    // HashMap
    public int usingHashMap(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0 ;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

}
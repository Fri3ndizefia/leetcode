package com.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS篇
 * 组合类
 * 电话号码的字母组合，参考九宫格输入法
 */
public class solution17 {
    public List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<String>();
        int len = digits.length();
        if (len == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(combinations, digits, phoneMap, 0, len, new StringBuffer());
        return combinations;
    }

    public void dfs(List<String> combinations, String digits, Map<Character, String> phoneMap,
                    int index, int len, StringBuffer combination) {
        if (index == len) {
            combinations.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; ++i) {
            combination.append(letters.charAt(i));
            dfs(combinations, digits, phoneMap, index + 1, len, combination);
            combination.deleteCharAt(index);
        }
    }
}

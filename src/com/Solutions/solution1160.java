package com.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<String> learntWords = new ArrayList<String>();
        for (Character c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (String s : words) {
            learntWords.add(s);
            Map<Character, Integer> used = new HashMap<Character, Integer>();
            for (Character c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    learntWords.remove(s);
                    break;
                }
                if (used.containsKey(c) && used.get(c).equals(map.get(c))) {
                    learntWords.remove(s);
                    break;
                }
                used.put(c, used.getOrDefault(c, 0) + 1);
            }
        }
        int res = 0;
        for (String s : learntWords) {
            res += s.length();
        }
        return res;
    }
}

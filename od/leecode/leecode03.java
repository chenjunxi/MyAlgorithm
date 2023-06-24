package com.leecode;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 无重复字符的最长子串
 * */
public class leecode03 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;


    }
}

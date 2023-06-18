package com.leecode;

import java.util.HashMap;

/*
无重复字符的最长子串
* */
public class Leetcode003 {
    public static void main(String[] args) {


        String s = "pwwkew";
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {

                index = Math.max(map.get(c)+1, index);

            }
            map.put(c, i);

            max = Math.max(max, i - index+1 );

        }

        System.out.println(max);

    }
}

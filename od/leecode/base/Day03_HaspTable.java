package com.leecode.base;

/*
*
判断t是否是s的字母异位，意思就是字母数量一样位置可能不一样
* */
public class Day03_HaspTable {
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        int[] dp = new int[25];

        for (int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            dp[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (dp[i] != 0) {
                System.out.println(false);
                break;
            }
        }

    }
}

package com.leecode;

/*
赎金信
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
判断第一个字符串 ransom 能不能由第二个字符串 magazines
里面的字符构成。如果可以构成，返回 true ；否则返回 false。

状态数组判断即可
* */
public class leecode383 {
    public static void main(String[] args) {

        String ransom = "aa";
        String magazines = "aab";

        int[] R = new int[26];
        int[] M = new int[26];

        for (int i = 0; i < ransom.length(); i++) {
            char c = ransom.charAt(i);
            R[c - 'a']++;
        }

        for (int i = 0; i < magazines.length(); i++) {
            char c = magazines.charAt(i);
            M[c - 'a']++;
        }

        if (check(R, M)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }

    private static boolean check(int[] r, int[] m) {

        for (int i = 0; i < 26; i++) {
            if (m[i] < r[i]) {
                return false;
            }
        }

        return true;
    }
}

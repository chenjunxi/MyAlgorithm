package com.leecode;
/*
*  找出字符串中第一个匹配项的下标
*两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
* 如果 needle 不是 haystack 的一部分，则返回  -1 。
\
* */
public class leecode28_2 {
    public static void main(String[] args) {

        System.out.println("abc".substring(0, 2));
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int index = 0;
            if (haystack.charAt(i) == needle.charAt(index) && haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;

    }
}

package com.leecode;


/*
* 重复的子字符串
判断字符串是否有多个重复的子串构成
* */
public class leecode459 {
    public static void main(String[] args) {

        System.out.println(check("abab"));
    }


    public static  boolean check(String s) {
        String str = s + s;
        String substring = str.substring(1, str.length() - 1);
        return substring.contains(s);
    }
}

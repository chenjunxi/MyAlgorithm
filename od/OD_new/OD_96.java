package com.od.OD.OD130;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 相似单词 什么是相似单词？原字符串通过任意调动位置得到的新字符串 如abc acb就是一组相似单词
 输出按字典排序输出,没有就输出null
4
abc
dasd
tad
bca
abc 给定的参考字符串，就是找出abc的相似字符串
输出 abc bca
4
abc
dasd
tad
bca
adb
输出null 因为没有adb的相似单词

怎么判断两个字符串为相似？转成数组排序，每个位置比较，只要有一个位置不相同就是不相似

 * */


public class OD_96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        String s;
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }
        s = in.next();

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < str.length; i++) {
            if (isXiangShi(s, str[i])) {
                set.add(str[i]);
            }
        }

        if (set.size() == 0) {
            System.out.println("null");
        } else {
            for (String c : set) {
                System.out.print(c + " ");
            }
        }
    }

    public static boolean isXiangShi(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}

package com.od.OD.OD130;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 相似单词
 * */


public class OD_96_new {
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

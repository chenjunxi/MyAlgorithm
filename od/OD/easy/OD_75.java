package com.od.OD.OD130;

import java.util.*;
import java.util.Scanner;
/*
*字符串解密
*
* */
public class OD_75 {
    public static String an () {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        HashSet<String> set = new HashSet<>();

        for (char c : s2.toCharArray()) {
            set.add(c + "");
        }

        String sub = "1234567890abcdef";
        int index = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (sub.contains(s1.charAt(i) + "")) {
                list.add(s1.substring(index, i));
                index = i + 1;
            } else {
                if (i == s1.length() - 1) {
                    list.add(s1.substring(index));
                }
            }
        }

        String end = "";
        for (int i = 0; i < list.size(); i++) {
            String cs = list.get(i);
            if (cs.length() > 0) {
                HashSet<String> cset = new HashSet<>();
                for (int j = 0; j < cs.length(); j++) {
                    cset.add(cs.charAt(j) + "");
                }
                int len = cset.size();

                if (len <= set.size()) {
                    HashSet<String> sset = new HashSet<>();
                    for (int j = 0; j < end.length(); j++) {
                        sset.add(end.charAt(j) + "");
                    }
                    int sslen = sset.size();
                    if (len > sslen) {
                        end = cs;
                    } else if (len == sslen && cs.compareTo(end) > 0) {
                        end = cs;
                    }

                }

            }

        }
        if (end.length() > 0) {
            return end;
        } else {
            return "Not Found";
        }

    }
    public static void main(String[] args) {
        String answer = an();
        System.out.println(answer);
    }
}
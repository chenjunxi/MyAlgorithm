package com.od.OD.OD130;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*寻找密码
h he hel hell helle
helle

* */
public class OD_25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] pwds = input.nextLine().split(" ");
        String ans = "";
        Set<String> all = new HashSet<>();
        for (String s : pwds) {
            all.add(s);
        }
        for (String s : pwds) {
            if (check(s, all)) {
                if (s.length() > ans.length()) {
                    ans = s;
                } else if (s.length() == ans.length() && s.compareTo(ans) > 0) {
                    ans = s;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean check(String s, Set<String> all) {
        for (int i = 0; i < s.length(); i++) {
            if (!all.contains(s.substring(0, i + 1))) {
                return false;
            }
        }
        return true;
    }
}

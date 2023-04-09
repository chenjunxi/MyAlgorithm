package com.od.OD.OD100;

import java.util.HashSet;
import java.util.Scanner;

public class OD_21_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            set.add(String.valueOf(c));
        }

        String[] split = s1.split("[0-9a-f]");

    }
}

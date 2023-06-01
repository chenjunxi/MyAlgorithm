package com.od.B.fenshu100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class OD49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("@");

        HashMap<String, Integer> last = new HashMap<>();
        LinkedList<String> strings = new LinkedList<>();
        String[] all = split[0].split(",");
        if (split.length == 1) {
            for (int i = 0; i < all.length; i++) {
                String[] spl = all[i].split(":");
                last.put(spl[0], Integer.valueOf(spl[1]));
                strings.add(spl[0]);
            }
            String o1 = "";
            for (int i = 0; i < strings.size(); i++) {
                Integer integer = last.get(strings.get(i));
                o1 = o1 + strings.get(i) + ":" + integer + ",";
            }
            String substring = o1.substring(0, o1.length() - 1);
            System.out.println(substring);
            return;
        }
        for (int i = 0; i < all.length; i++) {
            String[] spl = all[i].split(":");
            last.put(spl[0], Integer.valueOf(spl[1]));
            strings.add(spl[0]);

        }
        String[] bb = split[1].split(",");
        for (int i = 0; i < bb.length; i++) {
            String[] spl = bb[i].split(":");
            Integer integer = last.get(spl[0]);
            if (integer != null) {
                int i1 = last.get(spl[0]) - Integer.valueOf(spl[1]);
                if (i1 > 0) {
                    last.put(spl[0], i1);
                } else {
                    last.remove(spl[0]);
                    strings.remove(spl[0]);
                }

            }
        }
        String o = "";
        for (int i = 0; i < strings.size(); i++) {
            Integer integer = last.get(strings.get(i));
            o = o + strings.get(i) + ":" + integer + ",";
        }
        String substring = o.substring(0, o.length() - 1);
        System.out.println(substring);


    }
}

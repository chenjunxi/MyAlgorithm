package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD24 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int r = 0;
        int l = 0;

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l = i + 1;
            } else if (s.charAt(i) == ')') {
                r = i;
            }
            if (r != 0) {
                String[] ss = s.substring(l, r).split(",");  //利用小括号下标提取出坐标
                int j = Integer.parseInt(ss[0]);
                int w = Integer.parseInt(ss[1]);
                if (j > 0 && j < 1000 && w > 0 && w < 1000 && ss[0].charAt(0) != '0' && ss[1].charAt(0) != '0') {
                    list.add(j);
                    list.add(w);
                    lists.add(list);
                    list = new ArrayList<>();
                }
                l = r = 0;
            }
        }

        if (lists.size() == 0) {
            System.out.println("(0,0)");
        } else {
            lists.sort((a, b) -> { //对坐标进行降序排序
                int ax = a.get(0) * a.get(0) + a.get(1) * a.get(1);
                int bx = b.get(0) * b.get(0) + b.get(1) * b.get(1);
                if (bx >= ax) {
                    return 1;
                }
                return -1;
            });

            System.out.println("(" + lists.get(0).get(0) + "," + lists.get(0).get(1) + ")");
        }
    }
}

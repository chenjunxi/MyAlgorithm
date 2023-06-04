package com.od.B.EX;

import com.od.base.base01.HashCOde01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
报文回路 简单题

我理解互通就是 查询1 2 和 响应2 1

map存放，存在查询多次情况，如1 2 、1 2
5
1 2
2 3
3 2
1 2
2 1
输出True
意思上 1 2 发了两次报文查询，然后有响应了2 1 此路通；
2 3 发了一次报文，响应 3 2 此路通


* */
public class ODB19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 1) {
            System.out.println("False");
            return;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int d1 = in.nextInt();
            int d2 = in.nextInt();
            if (map.containsKey(d1)) {
                HashSet<Integer> integers = map.get(d1);
                integers.add(d2);
                map.put(d1, integers);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(d2);
                map.put(d1, set);
            }
        }


        for (Integer d1 : map.keySet()) { //遍历key
            for (Integer d2 : map.get(d1)) {  //遍历key中对应的值

                if (!map.containsKey(d2) || !map.get(d2).contains(d1)) {//
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");

    }
}
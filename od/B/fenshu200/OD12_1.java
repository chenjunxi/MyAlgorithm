package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class OD12_1 {

    public static List<int[]> linkList = new ArrayList<>();   //信号联通集合
    public static int min;  //广播的节点到各个节点之间的最小传播时延

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>(); //信号集合
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        for (int i = 0; i < n; i++) {
            int[] ints = new int[2];
            ints[0] = sc.nextInt();
            ints[1] = sc.nextInt();
            linkList.add(ints);
        }

        int start = sc.nextInt();
        list.remove(start - 1);   //将广播节点移除
        int max = 0;    //所有节点传播的最小时延

        for (int i = 0; i < m - 1; i++) {
            min = Integer.MAX_VALUE;
            time(start, list.get(i), 0);
            max = Math.max(0, min);
        }

        System.out.println(max * 2);
    }

    public static void time(int start, int end, int count) {

        for (int i = 0; i < linkList.size(); i++) {
            int u = linkList.get(i)[0];
            int v = linkList.get(i)[1];
            if (u == start) {
                if (v == end) {
                    min = Math.min(min, count + 1);
                    if (count == 0) {   //一个时延为最小时延，下面就不需要再找了
                        break;
                    }
                } else {
                    time(v, end, count + 1);
                }
            }
        }
    }
}

package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.Scanner;

/*
最小传输延时
3 3
1 2 11
2 3 13
1 3 50
1 3


思路：将关系存放list中，用数组存放关系，dfs向下统计
* */
public class OD18 {
    static public int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        int star = sc.nextInt();
        int end = sc.nextInt();


        dfs(list, star, end, 0);
        System.out.println(min);
    }

    private static void dfs(ArrayList<int[]> list, int star, int end, int count) {


        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            int u = ints[0];
            int v = ints[1];

            if (u == star) {
                if (v == end) {
                    count += ints[2];
                    min = Math.min(min, count);
                } else {
                    count += ints[2];
                    dfs(list, v, end, count);
                }
            }
        }

    }
}

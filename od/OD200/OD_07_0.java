package com.od.OD.OD200;

import java.util.HashSet;
import java.util.Scanner;

public class OD_07_0 {
    public static int[][] s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        s = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s[N][N] = sc.nextInt();
            }
        }

        HashSet<Integer> set = new HashSet<>();

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (set.contains(i)) {
                continue;
            }

            HashSet<Integer> temp = new HashSet<>();
            temp.add(i); //本身站点
            handle(temp, i);
            set.addAll(temp);
            res++;

        }

        System.out.println(res);
    }

    private static void handle(HashSet<Integer> temp, int n) {

        for (int j = 0; j < s.length; j++) {
            if (temp.contains(j)) {
                continue;
            }

            if (n != j && s[n][j] == 1) { //两个站点连接条件
                temp.add(j);
                handle(temp, j); //继续递归寻找更多连接的站点
            }
        }
    }
}

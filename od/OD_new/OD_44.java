package com.od.OD.OD130;
import java.util.Scanner;
import java.util.*;
/*
计算快递业务主站点
4 4
1 1 1 1
1 1 1 0
1 1 1 0
1 0 0 1
输出1 至少选择1个主站点出发，可以到达所有站点
* */
public class OD_44 {
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

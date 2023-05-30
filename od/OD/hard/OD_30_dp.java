package com.od.OD.bei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
*云短信平台优惠活动
经典背包问题

6   6相当于容量为6的背包
10 20 30 40 60 转化成下面的形式

物品 容量 价值
0 1 10
1 2 20
2 3 30
3 4 40
4 5 60

* */
public class OD_30_dp {
    public static int min_num;

    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int weight = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");

        int[] values = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();


        int n = values.length;
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = i + 1;
        }

        //dp[i][j]含义 表示0到i项，在j容量下，获得的最大价值
        int[][] dp = new int[n][weight + 1];

        //初始化，当取第0项的时候，获得的短信数量
        for (int i = 1; i <= weight; i++) {
            dp[0][i] = values[0];
        }

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < weight + 1; j++) {

                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[n - 1][weight]);

    }
}

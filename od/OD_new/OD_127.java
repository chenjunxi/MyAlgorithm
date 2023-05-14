package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;

/*
* 机智的外卖员  100分 23.Q1 动态规划
求最短达到目的楼层的时间
5 17
输出：4
步下到4楼  花一分钟
电梯4->8  花一分钟
电梯8->16 花一分钟
步上17楼  花一分钟
* */
class OD_127 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        if (N >= M) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[M + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = N - i;
        }
        for (int i = N + 1; i <= M; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
            }
        }
        System.out.println(dp[M]);
    }
}
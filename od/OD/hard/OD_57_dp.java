package com.od.OD.bei;

import java.util.Scanner;

//动态规划基础类型
public class OD_57_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n = sc.nextInt();

        int[] times = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int[][] dp = new int[n][T + 1];

        for (int i = 0; i < T + 1; i++) {
            if (i >= times[0]) {
                dp[0][i] = values[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < T + 1; j++) {

                if (times[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i]] + values[i]);
                }
            }
        }


        System.out.println(dp[n - 1][T]);
    }
}

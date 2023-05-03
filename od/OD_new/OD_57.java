package com.od.OD.OD130;

import java.util.Scanner;

//动态规划基础类型
public class OD_57 {
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

        int[] dp = new int[T + 1];

        for (int i = 0; i < times.length; i++) {
            for (int j = T; j >= times[i]; j--) {

                dp[j] = Math.max(dp[j], dp[j - times[i]] + values[i]);
            }
        }

        System.out.println(dp[T]);
    }
}

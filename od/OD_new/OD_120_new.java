package com.od.OD.OD130;

import java.util.Scanner;
/*
*超级玛丽过吊桥
* */
public class OD_120_new {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int K = in.nextInt();

        int[] lives = new int[64];
        for (int i = 0; i < K; i++) {
            int temp = in.nextInt();
            lives[temp] = 1;
        }

        int[][] dp = new int[64][64];
        //起始位置为1种走法
        dp[0][M] = 1;
        int res = 0;
        for(int i = 1;i <= N + 1;i++)
            for(int j = 1;j <= M;j++) {
                dp[i][j] += dp[i - 1][j + lives[i]];
                if(i - 2 >= 0)
                    dp[i][j] += dp[i - 2][j + lives[i]];

                if(i - 3 >= 0)
                    dp[i][j] += dp[i - 3][j + lives[i]];

                if(i == N + 1)
                    res += dp[i][j];
            }
        System.out.println(res);
    }

}
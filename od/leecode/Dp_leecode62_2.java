package com.leecode;

/*
 * 不同路径
 * */
public class Dp_leecode62_2 {
    public static void main(String[] args) {

    }

    public static int dpDemo(int m, int n) {

        //dp定义：(0,0)到(i,j)有多少中方法
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];


    }
}

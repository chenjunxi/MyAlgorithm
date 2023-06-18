package com.leecode;

/*
*
*
dp[i]=dp[i-1]+dp[i-2]
**/
public class Dp01 {
    public static void main(String[] args) {
        int k = 4;
        int[] dp = new int[k + 1];


        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= k; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[k]);
    }
}

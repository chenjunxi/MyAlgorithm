package com.leecode;


/*
*
爬楼梯花最小代价
* */
public class Dp03 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};


        //达到第i层花费最小代价 dp[i-1]
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        System.out.println(dp[cost.length]);


    }
}

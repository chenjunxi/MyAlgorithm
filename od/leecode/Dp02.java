package com.leecode;

/*
*
* 爬楼梯
dp[i]表示爬到第i层楼梯一共有多少中方法

* */
public class Dp02 {
    public static void main(String[] args) {

        int k = 4;

        //do[i]=dp[i-1]+dp[i-2]
        int[] dp = new int[k + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < k + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(k);

    }
}

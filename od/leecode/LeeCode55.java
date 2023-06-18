package com.leecode;

public class LeeCode55 {
    public static void main(String[] args) {
        int[] num = {2, 3, 1, 1, 4};
        int first = num[0];


        //0到i最远位置
        int[] dp = new int[num.length];

        for (int i = 1; i < num.length; i++) {
            dp[i] = Math.max(dp[i - 1], num[i] + 1);
            if (dp[i] > num.length - 1) {
                System.out.println(true);
                return;
            }

            if (dp[i] == i) {
                System.out.println(false);
                return;
            }
        }

    }
}

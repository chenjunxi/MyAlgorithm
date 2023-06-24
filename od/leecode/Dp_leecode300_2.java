package com.leecode;

import java.util.Arrays;

/*
 * 最长递增子序列
 *
 * */
public class Dp_leecode300_2 {
    public static void main(String[] args) {

        int[] nums = {};
//dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res
        );
    }
}

package com.leecode;

import java.util.Arrays;
/*
*
最长连续子序列，和最长连续和差不多
* */
public class Dp_leecode674 {
    public static void main(String[] args) {

        int[] nums = {};

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }

            res = Math.max(res, dp[i + 1]);
        }
    }

    //贪心
    private static void demo(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // 连续记录
                count++;
            } else { // 不连续，count从头开始
                count = 1;
            }
            if (count > result) result = count;
        }
    }
}

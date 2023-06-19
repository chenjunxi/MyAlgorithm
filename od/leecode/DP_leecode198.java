package com.leecode;

/*
* 打家劫舍

偷和不偷两种情况
偷：dp[i - 2] + nums[i]
不偷：dp[i - 1]
* */
public class DP_leecode198 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }

        System.out.println(dp[nums.length - 1]);

    }
}

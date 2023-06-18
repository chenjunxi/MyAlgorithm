package com.leecode;

import java.util.Arrays;

/*
*
最大连续和

* */
public class LeetCode53 {
    public static void main(String[] args) {

        int[] aa = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        maxSubArray3(aa);
    }

    //正数增益
    public static int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];

        int ans = nums[0];

        int sum = 0;

        for (int num : nums) {

            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static int maxSubArray2(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];

        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return 0;
    }


    public static void maxSubArray3(int[] nums) {
        int pre = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            pre = Math.max(nums[i], pre + nums[i]);
            ans = Math.max(ans, pre);
        }

        System.out.println(ans);
    }

}

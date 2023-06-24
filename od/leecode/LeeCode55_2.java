package com.leecode;

/*
*
跳跃游戏
dp[i]：从[0,i]的任意一点处出发，你最大可以跳跃到的位置。
* */
public class LeeCode55_2 {
    public static void main(String[] args) {
        int[] num = {2, 3, 1, 1, 4};


    }

    //贪心算法
    public boolean canJump1(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i] + i);

            if (max >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (dp[i] >= nums.length - 1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }
        return true;
    }

}

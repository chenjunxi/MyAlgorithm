package com.od.B.fenshu200;

import java.util.Scanner;

public class OD16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        //包含第一个数字，不包含最后一个数字
        int[] numsStart = new int[strings.length - 1];
        //不包含第一个数，包含最后一个数
        int[] numsEnd = new int[strings.length - 1];
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            int num = Integer.valueOf(strings[i]);
            if (i == 0) {
                numsStart[i] = num;
                continue;
            }
            if (i == len - 1) {
                numsEnd[i - 1] = num;
                break;
            }
            numsStart[i] = num;
            numsEnd[i - 1] = num;
        }

        int res = Math.max(handle(numsStart), handle(numsEnd));

        System.out.println(res);
    }

    /**
     * 动态规划 d[i] = Math.max( dp[i-1], dp[i-2] + nums[i])
     *
     * @param nums
     * @return
     */

    public static int handle(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }

        return dp[nums.length - 1];
    }
}

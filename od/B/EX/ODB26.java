package com.od.B.EX;

import java.util.Scanner;

/*
*软盘拷贝文件
背包题目
首先明确 weight value
本题最大背包容量固定是int W = 1474560 / 512;
文件大小就是weight和value
dp[i][j] 含义就是下标为0-i的物品里任意取，放进背包容量为j的背包里，价值总和最大是多少

6
600000
200000
200000
200000
400000
400000

输出：
1400000
* */
public class ODB26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        //总容量
        int W = 1474560 / 512;

        int[][] dp = new int[n][W + 1];

        //初始化
        for (int i = 0; i < W + 1; i++) {
            int size = (int) Math.ceil(nums[0] / 512.0);
            if (i >= size) {
                dp[0][i] = size;
            }

        }


        for (int i = 1; i < n; i++) {
            int size = (int) Math.ceil(nums[i] / 512.0);

            for (int j = 0; j <= W; j++) {
                if (size > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - size] + nums[i]);
                }
            }
        }

        System.out.println(dp[n - 1][W]);
        return;
    }
}

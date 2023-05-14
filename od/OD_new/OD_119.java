package com.od.OD.OD130;

import java.util.Scanner;

/*
* 高速公路休息站充电规划
每次充电固定1小时
1500 甲到乙距离1500公里
4 有4个充电站
300 2 距离甲300公里，需要排队2个小时
600 1
1000 0
1200 0
输出16 需要16个小时 全程1500/100 + 1（在第三个服务站充电需要1个小时）=16
* */
public class OD_119 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int D = in.nextInt();
        int N = in.nextInt();
        int[][] charg_pos = new int[N + 2][2];
        //起点当作第一个充电站
        charg_pos[0][0] = 0;
        charg_pos[0][1] = 0;

        for (int i = 1; i < N + 1; i++) {
            charg_pos[i][0] = in.nextInt();
            charg_pos[i][1] = in.nextInt();
        }

        //终点当作第一个充电站
        charg_pos[N + 1][0] = D;
        charg_pos[N + 1][1] = 0;

        //dp[i]表示第i号充电站，并在i充电花费的最短时间
        int[] dp = new int[N + 2];
        dp[0] = 0;
        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int res = 0;
        for (int i = 1; i <= N + 1; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (charg_pos[i][0] - charg_pos[j][0] > 1000)
                    break;
                else
                    dp[i] = Math.min(dp[i], dp[j] + charg_pos[i][1] + 1);
            }
            if (dp[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(dp[N + 1] + D / 100 - 1);
    }

}
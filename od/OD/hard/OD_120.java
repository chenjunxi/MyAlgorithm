package com.od.OD.bei;

import java.util.Scanner;

/*
*超级玛丽过吊桥
起点 吊桥 终点  关键理解死亡后还有剩余的生命，也就是说达到终点的时候生命数>=1
走到下一个木板（计1） 可以跨1个木板（计2） 可以跨2个木板（计3）
2 2 1 分别是生命数、吊桥长度、缺少板块数
2 第2块板是缺失的
输出4 共4中走法
动态规划解法

* */
public class OD_120 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int K = in.nextInt();

        int[] lives = new int[64];
        for (int i = 0; i < K; i++) {
            int temp = in.nextInt();
            lives[temp] = 1;
        }

        //dp[i][j]走到第i块木板消耗生命值为j的走法个数
        int[][] dp = new int[64][64];
        //起始位置为1种走法,因为走上终点也算一步，也就是一种走法
        dp[0][M] = 1;
        int res = 0;
        for (int i = 1; i <= N + 1; i++) //因为走上终点也算一步，相当于隐藏多了一块木板
            for (int j = 1; j <= M; j++) {
                dp[i][j] += dp[i - 1][j + lives[i]]; //走一步
                if (i - 2 >= 0)
                    dp[i][j] += dp[i - 2][j + lives[i]];//走两步

                if (i - 3 >= 0)
                    dp[i][j] += dp[i - 3][j + lives[i]];//走三步

                if (i == N + 1)  //达到了终点
                    res += dp[i][j];
            }
        System.out.println(res);
    }

}
package com.od.OD.OD130;

import java.util.Scanner;
/*
*响应报文时间
求所有报文响应时间，分为大于128 和小于128情况计算
3
0 20 第一列表示收到报文时间 第二列是响应时间
1 10
8 20
输出11 因为3个报文接受的时间都在第一个报文响应20秒内，所以选择响应时间最小的，也就是第二个报文1+10=11
2
0 255
200 60
输出
260
* */
public class OD_122 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        int[] T = new int[C];
        int[] M = new int[C];

        for (int i = 0; i < C; i++) {
            T[i] = in.nextInt();
            M[i] = in.nextInt();
        }
        int responseTime = 0;
        for (int i = 0; i < C; i++) {
            int maxRespTime = 0;
            if (M[i] < 128) {
                maxRespTime = M[i];
            } else {
                int exp = (M[i] & 0x70) >> 4;
                int mant = M[i] & 0x0F;
                maxRespTime = (mant | 0x10) << (exp + 3);
            }
            int newRespTime = T[i] + maxRespTime;

            if (i == 0 || newRespTime < responseTime) {
                responseTime = newRespTime;
            }
        }
        System.out.println(responseTime);
    }

}
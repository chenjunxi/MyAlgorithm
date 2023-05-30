package com.od.OD.OD130;

import java.util.Scanner;

/*
*响应报文时间
求所有报文响应最小时间，分为大于128 和小于128情况计算
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

思路：逻辑题，主要记住两个公式
int exp = (M[i] & 0x70) >> 4;
int mant = M[i] & 0x0F;
* */
public class OD_122 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];
        int[] M = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            M[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int resptime = T[i];

            if (M[i] < 128) {
                resptime += M[i];
            } else {
                int exp = (M[i] & 0x70) >> 4;
                int mant = M[i] & 0x0F;
                resptime += (mant | 0x10) << (exp + 3);
            }

            res = Math.min(resptime, res);
        }

        System.out.println(res);

    }

}
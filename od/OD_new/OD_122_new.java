package com.od.OD.OD130;

import java.util.Scanner;
/*
*响应报文时间
* */
public class OD_122_new {
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
package com.od.B.fenshu100;

import java.util.Scanner;

/*
 *
 * 报文响应时间
 *
 * 看题逻辑题
 * */
public class OD17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {

            int respTime;
            int T = sc.nextInt();
            int M = sc.nextInt();
            if (M >= 128) {
                //需要转换成二进制来计算
                String str = Integer.toString(M, 2);
                //低1-4位
                int mant = Integer.parseInt(str.substring(4), 2);
                //高5-7位
                int exp = Integer.parseInt(str.substring(1, 4), 2);
                M = (mant | 0x10) << (exp + 3);
            }
            respTime = T + M;
            min = Math.min(min, respTime);
        }

        System.out.println(min);

    }

}

package com.od.B.fenshu200;

import java.util.Scanner;

public class OD14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = sc.nextInt();
            }

            int preSum = 0;
            //是否满足条件
            boolean isTrue = false;
            //余数数组
            int[] yushu = new int[m];
            yushu[0] = 1;
            for (int i = 0; i < n; i++) {

                preSum += ints[i];
                preSum %= m;
                if (yushu[preSum] != 0) {
                    //前面有这个余数，说明可以进行整除
                    isTrue = true;
                    break;
                }
                yushu[preSum]++;
            }

            System.out.println(isTrue ? 1 : 0);
        }
    }
}

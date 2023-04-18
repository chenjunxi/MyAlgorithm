package com.od.OD.OD200;

import java.util.Scanner;

//二分查找 先求得最小值和最大值，
public class OD_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int len = sc.nextInt();

        long total = 0;
        long max = 0;
        long[] boxs = new long[len];
        for (int i = 0; i < len; i++) {
            boxs[i] = sc.nextInt();
            total += boxs[i];
            max = Math.max(max, boxs[i]);
        }

        if (total <= sum) {
            System.out.println("[]");
        } else {
            long l = sum/len, r = max;
            while (l < r) {
                long mid = l + 1 + ((r - l) >> 1); //为什么要加1，因为假如不加一的时候计算得出的值等于sum

                long tmp = 0;
                for (int i = 0; i < boxs.length; i++) {
                    tmp += Math.min(mid, boxs[i]);
                }

                if (tmp <= sum) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            System.out.print("[");
            for (int i = 0; i < boxs.length - 1; i++) {
                long max1 = Math.max(0, boxs[i] - l);
                System.out.print(max1 + ",");
            }
            System.out.print(Math.max(0, boxs[boxs.length - 1] - l));
            System.out.print("]");

        }

    }
}

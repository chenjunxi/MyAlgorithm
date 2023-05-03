package com.od.OD.OD130;

import java.util.Scanner;
/*
* 贪心的商人
*
* */
public class OD_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int days = sc.nextInt();
        int[] item = new int[number];

        for (int i = 0; i < number; i++) {
            item[i] = sc.nextInt();
        }

        int[][] item_price = new int[number][days];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                item_price[i][j] = sc.nextInt();
            }
        }

        int res = 0;

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days - 1; j++) {
                int in = item_price[i][j]; //只有第二天价格大于当天的，才加入计算
                int out = item_price[i][j + 1];
                if (out > in) {
                    res += (out - in) * item[i];
                }
            }
        }

        System.out.println(res);
    }
}

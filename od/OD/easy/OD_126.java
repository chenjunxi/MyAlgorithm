package com.od.OD.OD130;

import java.util.Scanner;

/*
*购买水果最便宜的方案
4 n个小时
6 M个超市
2 3 10 2到3小时价格为10元
2 4 20
1 3 15
1 4 25
3 4 8
1 4 16
输出：41
第一小时15
第二小时10
第三小时8
第四小时8

用数组表示每个小时的最低价格，即可。然后数组总和就是最低价格
* */
class OD_126 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] min_price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            min_price[i] = Integer.MAX_VALUE;
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            for (int j = a; j <= b; j++) {
                if (min_price[j] > c) {
                    min_price[j] = c;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += min_price[i];
        }
        System.out.println(sum);
    }
}
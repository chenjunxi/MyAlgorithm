package com.od.B.fenshu100;

import java.util.Scanner;

public class OD33 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int len = str.length;
        int[] ints = new int[len];  //数字数组
        int cnt = 0;    //满足条件的数字个数

        for (int i = 0; i < len; i++) {
            ints[i] = Integer.valueOf(str[i]);
            if (ints[i] < n) {
                cnt++;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len - cnt + 1; i++) {
            int count = 0;
            for (int j = 0; j < cnt; j++) {
                if (ints[i + j] >= n) {
                    count++;
                }
            }
            res = Math.min(res, count);
        }

        System.out.println(res);
    }
}

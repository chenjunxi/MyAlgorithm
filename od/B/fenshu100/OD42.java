package com.od.B.fenshu100;

import java.util.Scanner;

public class OD42 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] parking = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                parking[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (parking[i][j] == 1) {
                    //本身停车了
                    res++;
                } else if (i > 0 && parking[i - 1][j] == 1) {
                    //上方停车了
                    res++;
                } else if (i < m - 1 && parking[i + 1][j] == 1) {
                    //下方停车了
                    res++;
                } else if (j > 0 && parking[i][j - 1] == 1) {
                    //左方停车了
                    res++;
                } else if (j < n - 1 && parking[i][j + 1] == 1) {
                    //右方停车了
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}

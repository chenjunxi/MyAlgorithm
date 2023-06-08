package com.od.B.fenshu100;

import java.util.Scanner;

/*
* 矩阵最大值
左右移动二进制位置，达到值最大
5
1,0,0,0,1
0,0,0,1,1
0,1,0,1,0
1,0,0,1,1
1,0,1,0,1
* */
public class OD60 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine().replaceAll(",", "");

            int max = 0;
            for (int j = 0; j < n; j++) {
                String s = str.substring(j) + str.substring(0, j);

                max = Math.max(max, Integer.valueOf(s, 2));
            }
            res += max;
        }

        System.out.println(res
        );

    }
}

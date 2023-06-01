package com.od.B.fenshu100;

import java.util.Scanner;

public class OD56 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();
        //各个字符的个数
        int Q = 0, U = 0, A = 0, C = 0, K = 0, res = 0;
        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);
            if (c == 'q') {
                Q++;
            } else if (c == 'u') {
                U++;
            } else if (c == 'a') {
                A++;
            } else if (c == 'c') {
                C++;
            } else if (c == 'k') {
                K++;
            } else {
                //非有效组合
                res = -1;
                break;
            }
            if (!(Q >= U && U >= A && A >= C && C >= K)) {
                res = -1;
                break;
            }

            res = Math.max(res, Q - K);
        }

        System.out.println(res);
    }
}

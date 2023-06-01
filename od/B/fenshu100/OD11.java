package com.od.B.fenshu100;

import java.util.Scanner;

public class OD11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int len = s.length;

        int[] ints = new int[len];

        int num = 0;
        for (int i = 0; i < len; i++) {
            num += Integer.valueOf(s[i]);     //计算出符合的次数
        }
        int step = 7;   //直接从7开始
        while (num > 0) {
            if (step % 7 == 0 || String.valueOf(step).contains("7")) {
                ints[(step - 1) % len]++;      //同过数组长度算出符合的下标
                num--;      //符合的次数递减
            }
            step++;     //报数的次数递增
        }

        String res = "";
        for (int i = 0; i < len; i++) {
            res += String.valueOf(ints[i]);
            if (i == len - 1) {
                break;
            }
            res += " ";
        }

        System.out.println(res);
    }

}

package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

/*
求任意两个数围成的最大面积
10,1,2,3,4,5,10
输出60
10,9,8,7,6,5,4,3,2,1
输出25

暴力双层遍历 感觉会超时
 for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
          int i1 = (j - i) * Math.min(num[i], num[j]);
          max = Math.max(max, i1);
     }
 }


* */
public class OD02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String[] ss = s.split(",");

        int length = ss.length;

        int[] num = new int[length];   //将输入放入整数数组中

        for (int m = 0; m < length; m++) {
            num[m] = Integer.parseInt(ss[m]);
        }


        int max = 0;    //最大面积
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int i1 = (j - i) * Math.min(num[i], num[j]);
                max = Math.max(max, i1);
            }
        }

        System.out.println(max);

    }
}

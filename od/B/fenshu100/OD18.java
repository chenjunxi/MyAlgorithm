package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();

        int[] a = new int[m];
        int[] b = new int[n];

        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {    //遍历A数组

            int[] ints = new int[2];    //用来放置A、B数字
            int index = 0;  //B数组下标

            while (index < b.length) {
                if (a[i] <= b[index] && b[index] - a[i] <= R) {
                    ints[0] = a[i];
                    ints[1] = b[index];
                    list.add(ints);
                    break;
                }
                index++;
            }
        }

        list.forEach(e -> {
            System.out.println(e[0] + " " + e[1]);
        });
    }
}

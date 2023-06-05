package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 事件推送
4 5 5
1 5 5 10
1 3 8 8 20


思路：双循环，注意b数组的开始遍历位置
* */
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

            for (int j = index; j < b.length; j++) {

                if (b[j] >= a[i] && b[j] - a[i] <= R) {
                    list.add(new int[]{a[i], b[j]});
                    index = j + 1;
                    break;
                }
            }
        }

        list.forEach(e -> {
            System.out.println(e[0] + " " + e[1]);
        });
    }
}

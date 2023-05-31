package com.od.OD.bei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 红黑树
 * 比如3个节点就是8种组合，给每一种染色，i=0：000，i=1:100,i=2:010,i=3:101,i=4:001,101,010,110,111组合啊
3 3
0 1
0 2
1 2
输出4
 * */
public class OD_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[]> list = new ArrayList<>();   //相连的节点数组集合
        for (int i = 0; i < m; i++) {
            int[] points = new int[2];
            points[0] = sc.nextInt();
            points[1] = sc.nextInt();
            list.add(points);
        }

        int total = (int) Math.pow(2, n);   //n个节点有2^n个红黑搭配
        int res = total;
        for (int i = 0; i < total; i++) {

            int temp = i;
            int[] ints = new int[n];    //红黑搭配的情况（0表示红，1表示黑）
            for (int j = 0; j < n; j++) {
                ints[j] = temp % 2;
                temp /= 2;
            }

            for (int[] points : list) {
                if (ints[points[0]] == 0 && ints[points[1]] == 0) {   //相连的节点都是红色，表示不符合
                    res--;
                    break;  //任意一个相连不符则表示此情况不符合
                }
            }
        }

        System.out.println(res);
    }
}
package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

/*
* 分苹果
异或运算：相同为0，异为1
隐藏规律就是相同两个数进行异或一定等于0

所以本题满足A的分苹果计划就是，所有数进行异或一定等于0，不等于0就输出-1
求B获得最大苹果数量，那就是在所有苹果数找到最小的，剩下的之和就是B获得最大的总量

如：3 5 6
3^5^6=0,满足条件
取最小值就是3，则B获得的数据量就是3+5+6-3=11

* */
public class OD01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        //苹果数组
        int[] apples = new int[num];
        for (int i = 0; i < num; i++) {
            apples[i] = sc.nextInt();
        }

        //求出所有苹果的异或值
        int count = apples[0];
        for (int i = 1; i < num; i++) {
            count ^= apples[i];
        }

        int res = -1;
        if (count == 0) {
            //异或值等于0说明满足A的分苹果方案
            //苹果中最小的重量
            int min = Arrays.stream(apples).min().getAsInt();
            //所有苹果的总重量
            int total = Arrays.stream(apples).sum();
            res = total - min;
        }

        System.out.println(res);
    }

}

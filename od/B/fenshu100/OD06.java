package com.od.B.fenshu100;

import java.util.Scanner;

/*
*阿里巴巴选黄金宝箱1
黄金宝箱左右之和相等，和之前左右乘机题类似。
第一个元素左边和定义为0，最后一个元素右边和定义为0

2,5,-1,8,6
输出3

思路：左右前缀和，声明左数组和右数组，分别记录索引位置的左边和、右边和
* */
public class OD06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String numString = scanner.nextLine();
        String[] strings = numString.split(",");
        int n = strings.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        leftArr[0] = 0;
        rightArr[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            leftArr[i] = leftArr[i - 1] + Integer.parseInt(strings[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] + Integer.parseInt(strings[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            if (leftArr[i] == rightArr[i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}


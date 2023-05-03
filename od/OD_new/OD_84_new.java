package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
* 最大连续文件之和 / 区块链文件转储系统
*
* */
class OD_84_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int M =in.nextInt();
        in.nextLine();
        Integer[] F = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        // 窗口左右边界
        int left = 0, right = 0;
        //窗口和
        int window_sum = 0;
        //最大窗口和
        int window_max = 0;

        while (right < F.length) {
            int temp = window_sum + F[right];

            // 窗口内总和大了，sum减去左边界，左端边界+1
            if (temp > M) {
                window_sum -= F[left];
                left += 1;
            }
            // 窗口内总和小了，右边界+1，sum加上右边界
            else if (temp < M) {
                window_sum += F[right];
                window_max = Math.max(window_sum, window_max);
                right += 1;
            }
            // 窗口内总和==M，直接return
            else {
                System.out.println(M);
                return;
            }
        }

        System.out.println(window_max);
    }

}
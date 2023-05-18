package com.od.OD.OD130;

import java.util.Scanner;

/*
 * 相同数字积木游戏
 * 遍历数组，从头和尾开始比较
5
1
2
3
1
4
 * */
public class OD_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }

        System.out.println(max);

    }
}

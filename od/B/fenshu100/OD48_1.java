package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

/*
* 阿里巴巴找黄金
求连续K个数最大和
2,10,-3,-8,40,5
4
输出39
10,1,2,3,4,5,10
3
思路：滑窗，左减右加
* */
public class OD48_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ints = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();


        int count = 0;
        for (int i = 0; i < k; i++) {
            count += ints[i];
        }

        int left = ints[0];
        int max = count;
        for (int i = 1; i < ints.length - k + 1; i++) {

            int right = ints[i + k - 1];
            count -= left;
            count += right;
            left = ints[i];
            max = Math.max(max, count);

        }

        System.out.println(max);
    }

    private static void demo() {
        Scanner sc = new Scanner(System.in);

        int[] ints = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        //滑窗的左侧边界
        int left = 0;
        //滑窗的右侧边界
        int right = 0;
        //滑窗内的总和
        int count = 0;
        //最大和
        int max = Integer.MIN_VALUE;
        while (right < ints.length) {

            count += ints[right];
            right++;
            if (right - left < k) {
                //滑窗大小不满足咒语数字则右边界继续向右滑动
                continue;
            }
            max = Math.max(max, count);
            //滑窗大小已经满足咒语数字，则左边界需要右移
            count -= ints[left];
            left++;
        }

        System.out.println(max);
    }
}

package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

public class OD48 {
    public static void main(String[] args) {

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

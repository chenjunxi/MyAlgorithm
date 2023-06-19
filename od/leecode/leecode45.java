package com.leecode;

import java.util.Arrays;
/*
*
* 跳跃游戏2
*
至少跳几次到终点
* */
public class leecode45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};


        int end = 0;
        int maxposition = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxposition = Math.max(maxposition, nums[i] + i);

            if (i == end) {
                end = maxposition;
                step++;
            }
        }
        System.out.println(step);
    }
}

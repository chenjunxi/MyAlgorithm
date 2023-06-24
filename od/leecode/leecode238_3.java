package com.leecode;

import java.util.Arrays;

/*
 * 除自身以外数组的乘积
 *
 左右前缀乘积

原数组：       [1       2       3       4]
左部分的乘积：   1       1      1*2    1*2*3
右部分的乘积： 2*3*4*1   3*4*1  4*1    1
结果：        1*2*3*4   1*3*4  1*2*4*1  1*2*3*1
 * */
public class leecode238_3 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int length = nums.length;
        int[] ans = new int[length];

        int left = 1, right = 1;
        for (int i = 0; i < length; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        System.out.println(Arrays.toString(ans));

        //最后一个元素直接不用计算了
        for (int i = length - 1; i > 0; i--) {
            right *= nums[i];
            ans[i - 1] *= right;
        }
        System.out.println(Arrays.toString(ans));
    }

    private static void demo(int[] nums, int length) {
        int[] ans = new int[length];

        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        left[1] = nums[0];
        for (int i = 2; i < length; i++) {
            int a = nums[i - 1];
            int b = left[i - 1];
            left[i] = a * b;
        }

        right[length - 1] = 1;
        right[length - 2] = nums[length - 1];


        for (int i = length - 3; i >= 0; i--) {
            int a = nums[i + 1];
            int b = right[i + 1];
            right[i] = a * b;
        }

        for (int i = 0; i < length; i++) {
            ans[i] = left[i] * right[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}

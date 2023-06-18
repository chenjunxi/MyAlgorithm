package com.leecode.base;

import java.util.Arrays;

public class Day01_Array02 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        int[] res = new int[nums.length];

        int left = 0, right = nums.length - 1;

        int index = nums.length - 1;
        while (left <= right) {

            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (b > a) {
                res[index--] = b;
                right--;
            } else {
                res[index--] = a;
                left++;
            }

        }

        System.out.println(Arrays.toString(res));
    }
}

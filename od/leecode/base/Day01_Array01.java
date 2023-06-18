package com.leecode.base;
/*
*
* 原数组删除指定元素
* */
public class Day01_Array01 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != target) {
                nums[index++] = nums[i];
            }
        }

        System.out.println(index);

    }
}

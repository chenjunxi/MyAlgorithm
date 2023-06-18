package com.leecode.base;

public class Day01_Array03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;


        int left = 0, right = 0;
        int sum = nums[0];
        int min = nums.length;
        while (left != nums.length - 1) {
            if (sum == target) {
                min = Math.min(min, right - left + 1);
                if (right == nums.length - 1) break;
                sum -= nums[left++];
                sum += nums[++right];
            } else if (sum < target && right != nums.length - 1) {
                sum += nums[++right];
            } else {
                sum -= nums[left++];
            }

        }

        System.out.println(min);
    }
}

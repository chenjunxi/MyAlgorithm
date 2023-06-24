package com.leecode;
/*
* 旋转数组查找数字
* 二分查找
*
* */
public class leecode33_2 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        if (nums.length == 0) return -1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

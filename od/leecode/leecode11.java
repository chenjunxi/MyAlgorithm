package com.leecode;
/*
*
盛最多容器
双指针，谁小谁移到
* */
public class leecode11 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int sum = 0;

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int h = Math.min(arr[left], arr[right]);
            int s = h * (right - left);


            sum = Math.max(sum, s);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }

        }

        System.out.println(sum);
    }
}

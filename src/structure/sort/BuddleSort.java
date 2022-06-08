package com.Day05;

import java.util.Arrays;

public class BuddleSort {

    public static void buddleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        boolean flag = false;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            System.out.printf("第%d次排序后结果:\n",arr.length-i );
            System.out.println(Arrays.toString(arr));

            if (!flag) { // 当flag=false表示已经有序
                break;
            } else {
                flag = false;
            }
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        buddleSort(arr);
    }

}

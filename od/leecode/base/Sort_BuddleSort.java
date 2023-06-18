package com.leecode.base;

import java.util.Arrays;
/*
冒泡排序思路：

- 一共进行arr.length-1次数循环
- 第一次从arr[0] 开始相邻两两位置比较，产生逆序则进行交换，直到把最值放在arr[n-1]
- 第二次从arr[0] 开始相邻两两位置比较，产生逆序则进行交换，直到把最值放在arr[n-2]
- 第n-1次从arr[0] 开始相邻两两位置比较，产生逆序则进行交换，直到把最值放在arr[1]

* */
public class Sort_BuddleSort {

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

package com.Day06;

import java.util.Arrays;

public class SelectionSort {


    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int j = 0; j < arr.length - 1; j++) {
            int min = j;
            for (int i = j; i < arr.length - 1; i++) {
                min = arr[i] < arr[min] ? i : min; //找出最值的数组索引
            }

            if (min != j) { //判断位置是否相同
                swap(arr, min, j); //交换位置
            }

            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;

        //如果if (min != j)不做判断的话，不能使用位运算
        //因为min=j的时候使用位运算，结果为0
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 33, 22, 34};
        selectionSort(arr);
    }
}

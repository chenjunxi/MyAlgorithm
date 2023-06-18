package com.leecode.base;

import java.util.Arrays;

public class Sort_MergeSort {

    public static void mergerSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) return;

        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);//左侧已经有序
        process(arr, mid + 1, R);//右侧有序
        merge(arr, L, mid, R); //左右侧整体有序
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];  //定义辅助数组
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        //两边数组都没越界，谁小谁放在辅助数组上
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //假设右边数组已经越界，拷贝左边剩下的数据到辅助数组上
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        //假设左边数组已经越界，拷贝左边剩下的数据到辅助数组上
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        //把辅助数组已经排好顺序的数据拷贝到原数组上
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {55,45,34,32,22,20,5};
        mergerSort(arr);
    }
}

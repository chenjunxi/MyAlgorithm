package com.leecode.base;//插入排序
/*
插入排序基本思想：把n个待排序的元素看成为一个**有序表和一个无序表**，开始时有序表中值包含一个元素（往往arr[0]），无序表包含n-1个元素，排序过程中每次从无序表中提取**第一个元素**，把这个元素依次与有序表元素进行比较，插入到有序表中合适的位置，一直操作下去，使之成为有序表。

- 第一次是前2个元素变成有序：arr[0]和ar[1]比较
- 第二次是前3个元素变成有序：arr[0,1]和arr[2]比较
- 第N-1次是前N个元素变成有序：arr[0,....n-2]和arr[n-1]比较


* */
public class Sort_InserionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }


    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 3, 3, 4};
        insertionSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}

package com.Day01;

public class InserionSort {

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

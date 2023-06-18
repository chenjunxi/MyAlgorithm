package com.leecode.base;

import java.util.Arrays;
/*
*
*
*
* */
public class Sort_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
        System.out.println(Arrays.toString(arr));
		int size = arr.length;
		swap(arr, 0, --size);  //把最值扔到最后一个位置，并且最后一个位置不参与后面的计算
		while (size > 0) {
			heapify(arr, 0, size);  //不断的构造成大根堆
			swap(arr, 0, --size);  //替换最值，然后最后一位不参与后面的计算
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) /2);
			index = (index - 1)/2 ;
		}
	}

	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) { //当没孩子的时候也停

		    //判断左右孩子谁最大
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;

			//孩子和父亲的最值比较
			largest = arr[largest] > arr[index] ? largest : index;

			//孩子没大于父亲，就停
			if (largest == index) {
				break;
			}

			//如果孩子比父亲大，先交换位置，
			swap(arr, largest, index);
			//继续往下做重复比较
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}



	// for test
	public static void main(String[] args) {

		int maxSize = 10;
		int maxValue = 100;

		int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
		heapSort(arr);


	}

}

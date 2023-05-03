package com.od.OD.OD130;

import java.util.Scanner;
/*
* 相同数字积木游戏
*
* */
public class OD_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = arr.length - 1;

        int max = -1;
        while (left < right) {

            if (arr[left] == arr[right]) {
                int i = right - left;
                max = Math.max(max, i);
                left++;
                right = arr.length - 1;
                continue;
            } else {
                right--;
            }
        }

        System.out.println(max);
    }
}

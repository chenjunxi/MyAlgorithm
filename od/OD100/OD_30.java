package com.od.OD.OD100;

import java.util.Arrays;
import java.util.Scanner;

//和28题类似的关键点
//滑动窗口，左右值，左减右加
public class OD_30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int[] hua = new int[n];
        for (int i = 0; i < n; i++) {
            hua[Integer.valueOf(arr[i])]++;
        }

        int max = 0;

        int left = Integer.valueOf(arr[0]);
        for (int i = 0; i < arr.length - n+1; i++) {
            int right = Integer.valueOf(arr[n - 1 + i]);
            if (i > 0) {
                hua[left]--; //左减
                hua[right]++; //右加
                left = Integer.valueOf(arr[i]);
            }
            int asInt = Arrays.stream(hua).max().getAsInt();
            max = Math.max(asInt, max);
        }

        System.out.println(max);

    }
}

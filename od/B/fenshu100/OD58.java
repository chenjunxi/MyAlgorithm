package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 最长连续子序列
1,2,3,4,2
6

思路：左右指针
 * */
public class OD58 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int M = sc.nextInt();

        int[] ints = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int left = 0, right = 0, sum = ints[left];

        int max = -1;
        while (left < ints.length && right < ints.length) {
            if (sum > M) {
                sum -= ints[left++];
            } else if (sum == M) {
                max = Math.max(max, right - left + 1);
                left++;
                right++;
            } else {
                sum += ints[right++];

            }
        }

        System.out.println(max);

    }
}

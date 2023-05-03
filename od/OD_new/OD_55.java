package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;

//取中间位置，有2个中间位置的时候，取考左的位置
public class OD_55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int site = nums.length % 2 == 0 ? nums[nums.length / 2 - 1] : nums[nums.length / 2];

        System.out.println(site);
    }
}

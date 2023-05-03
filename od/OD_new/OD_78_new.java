package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
/*
* 水库蓄水问题
* */
class OD_78_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        //转为数组
        Integer[] height = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n=height.length;

        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        // 第i个位置能蓄水的高度
        int[] water_height = new int[n];
        HashSet<Integer> water_heights = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            int water = Math.max(0, Math.min(left[i], right[i]) - height[i]);
            if (water != 0) {
                water_height[i] = water + height[i];
                water_heights.add(water_height[i]);
            }
        }

        int[] result = new int[3];
        int capacity = 0;

        for (int single_water_height : water_heights) {
            int l = 0;
            while (water_height[l] < single_water_height || height[l] >= single_water_height) {
                l++;
            }

            int r = n - 1;
            while (water_height[r] < single_water_height || height[r] >= single_water_height) {
                r--;
            }
            int total_water = 0;
            for (int i = l; i <= r; i++) {
                total_water += Math.max(0, single_water_height - height[i]);
            }

            if (total_water > result[2]) {
                result[0] = l - 1;
                result[1] = r + 1;
                result[2] = total_water;
            }

            else if (total_water == result[2]) {
                int dis1 = r - l + 1;
                int dis2 = result[1] - result[0] - 1;

                if (dis1 < dis2) {
                    result[0] = l - 1;
                    result[1] = r + 1;
                }
            }
        }

        if (result[2] == 0) {
            System.out.println(0);
        } else{
            System.out.print(result[0]);
            System.out.print(" ");
            System.out.print(result[1]);
            System.out.print(":");
            System.out.print(result[2]);
        }
    }
}

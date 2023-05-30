package com.od.OD.bei;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;

/*
 * 水库蓄水问题
 * 例如 s=[3 ,1,2] 选取 s[0]和s[2]作为边界 蓄水量为1，输出0 2:1
 * 当无法蓄水的时候，输出0

 * */
class OD_78 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //山脉的高度数组
        Integer[] height = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = height.length;
        //左侧最高山脉数组
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            //i左侧的最高山脉
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        //右侧最高山脉数组
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            //i右侧的最高山脉
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        //最大蓄水高度跟山脉的总高度数组
        int[] waterheight = new int[n];

        HashSet<Integer> waters_h = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            //当前山脉的最大蓄水量
            int wat = Math.max(0, Math.min(left[i], right[i]) - height[i]);
            if (wat != 0) {
                //最大蓄水量的高度+山脉的高度
                waterheight[i] = wat + height[i];
                waters_h.add(waterheight[i]);
            }
        }

        int[] result = new int[3];

        for (int sig : waters_h) {
            //左侧第一个满足条件的山脉
            int l = 0;
            while (waterheight[l] < sig || height[l] >= sig) {
                l++;
            }
            //右侧第一个满足条件的山脉
            int r = n - 1;
            while (waterheight[r] < sig || height[r] >= sig) {
                r--;
            }
            //蓄水量求和
            int total_wat = 0;
            for (int i = l; i <= r; i++) {
                total_wat += Math.max(0, sig - height[i]);
            }
            if (total_wat > result[2]) {
                //蓄水量大于之前的最大蓄水量则重置左右山脉索引和最大蓄水量
                result[0] = l - 1;
                result[1] = r + 1;
                result[2] = total_wat;
            } else if (total_wat == result[2]) {
                //蓄水量等于之前最大蓄水量则判断其山脉距离，选其距离较小的
                int d = r - l + 1;
                int d2 = result[1] - result[0] - 1;
                if (d < d2) {
                    result[0] = l - 1;
                    result[1] = r + 1;
                }
            }
        }
        if (result[2] == 0) {
            System.out.print(0);
        } else {
            System.out.print(result[0]);
            System.out.print(" ");
            System.out.print(result[1]);
            System.out.print(":");
            System.out.print(result[2]);

        }
    }
}

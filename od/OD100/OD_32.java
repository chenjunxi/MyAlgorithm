package com.od.OD.OD100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//双指针知识点，先排序体重，总重量大于M，右边移到，小于的话则两边一起移动
public class OD_32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        Arrays.sort(weights);

        // 3 2 2 1
        int small = 0;
        int big = weights.length - 1;
        int count = 0;

        int total = weights[big] + weights[small];
        while (small < big) {
            if (total > m) {
                count++;
                total = weights[big--] + weights[small];
            } else {
                count++;
                total = weights[--big] + weights[++small];
            }
        }


        System.out.println(count);
    }
}

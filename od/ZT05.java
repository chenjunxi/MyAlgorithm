package com.od.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ZT05 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] height = in.nextLine().split(" ");
        String[] weight = in.nextLine().split(" ");
        // 不用map存储，直接二维数组，存编号，身高和体重
        int[][] ints = new int[n][3];
        for(int i = 0; i < n; i++){
            ints[i][0] = i + 1;
            ints[i][1] = Integer.parseInt(height[i]);
            ints[i][2] = Integer.parseInt(weight[i]);
        }
        // 直接使用lambda表达式排序
        Arrays.sort(ints, (e1,e2)->(e1[1]==e2[1]?(e1[2]-e2[2]):(e1[1]-e2[1])));
        for(int i = 0; i < ints.length; i++) {
            if (i == ints.length - 1) {
                System.out.print(ints[i][0]);
            } else{
                System.out.print(ints[i][0] + " ");
            }
        }

    }

}


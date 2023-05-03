package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*幻方修复 100分 23.Q1
幻方条件：在一个二维数组中，每行、每列、对角线上的数字和都是一样，和值也是有规律的sum=n*(n*n+1)/2
下载要找出错误的两个数字并恢复，达到满足幻方条件
输出：第几行 第几列 正确数值
先找出哪些不满足和为sum，满足的重置为1
* */
class OD_129_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] line_sum = new int[n];
        int[] col_sum = new int[n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
                line_sum[i] += matrix[i][j];
                col_sum[j] += matrix[i][j];
            }
        }

        // 先求出不想等的两个行数
        List<Integer> lines = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int target = n * (n * n + 1) / 2;
        for (int i = 0; i < n; i++) {
            if (line_sum[i] != target) {
                lines.add(i);
            }

            if (col_sum[i] != target) {
                cols.add(i);
            }

        }

        //两行
        if (lines.size() == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (line_sum[lines.get(0)] - matrix[lines.get(0)][i] + matrix[lines.get(1)][j] == target) {
                        System.out.println((lines.get(0) + 1) + " " + (i + 1) + " " + matrix[lines.get(1)][j]);
                        System.out.println((lines.get(1) + 1) + " " + (j + 1) + " " + matrix[lines.get(0)][i]);
                        return;
                    }
                }
            }
        } else if (cols.size() == 2) {
            //两列
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (col_sum[cols.get(0)] - matrix[i][cols.get(0)] + matrix[j][cols.get(1)] == target) {
                        System.out.println((i + 1) + " " + (cols.get(0) + 1) + " " + matrix[j][cols.get(1)]);
                        System.out.println((j + 1) + " " + (cols.get(1) + 1) + " " + matrix[i][cols.get(0)]);
                        return;
                    }
                }
            }
        }


    }


}
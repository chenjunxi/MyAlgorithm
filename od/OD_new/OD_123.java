package com.od.OD.OD130;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*带传送阵的矩阵游离
* 在n*m矩阵中可以上下左右移到，代价是前后两个位置的元素值差的绝对值
* 有一次特权使用，跳到一次相同数字的位置上
*求左上角到右下角最少花多少代价
3 3
1 2 3
4 5 6
7 8 9
输出8  1 2 3 6 9=》1+1+3+6=8
3 3
1 2 3
4 5 6
7 1 4
输出3 1 1 4=》0+3=3
思路是先求左下角到每个点的最小代价(用map保存，key为每个点的，value为最小代价)，再求右下角到每个点的最小代价，然后两个集合相加

* */
class OD_123 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        //从左上角到右下角
        Map<Integer, Integer> left_map = new HashMap<>();
        int[][] left_arr = new int[n][m];
        int distance = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (i == 0) {
                    if (k == 0) {
                        distance = 0;
                        left_arr[i][k] = 0;
                    } else {
                        distance = Math.abs(matrix[i][k] - matrix[i][k - 1]) + left_arr[i][k - 1];
                        left_arr[i][k] = distance;
                    }
                }
                if (i != 0) {
                    if (k == 0) {
                        distance = Math.abs(matrix[i][k] - matrix[i - 1][k]) + left_arr[i - 1][k];
                        left_arr[i][k] = distance;
                    } else {
                        int top = matrix[i - 1][k];
                        int left = matrix[i][k - 1];
                        distance = Math.min(Math.abs(matrix[i][k] - top) + left_arr[i - 1][k], Math.abs(matrix[i][k] - left) + left_arr[i][k - 1]);
                        left_arr[i][k] = distance;
                    }
                }

                if (left_map.containsKey(matrix[i][k])) {
                    left_map.put(matrix[i][k], Math.min(left_map.get(matrix[i][k]), distance));
                } else {
                    left_map.put(matrix[i][k], distance);
                }
            }
        }

        //从右下角到左上角
        Map<Integer, Integer> right_map = new HashMap<>();
        int[][] right_arr = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int k = m - 1; k >= 0; k--) {
                if (i == n - 1) {
                    if (k == m - 1) {
                        distance = 0;
                        right_arr[i][k] = 0;
                    } else {
                        distance = Math.abs(matrix[i][k] - matrix[i][k + 1]) + right_arr[i][k + 1];
                        right_arr[i][k] = distance;
                    }
                }
                if (i != matrix.length - 1) {
                    if (k == matrix[i].length - 1) {
                        distance = Math.abs(matrix[i][k] - matrix[i + 1][k]) + right_arr[i + 1][k];
                        right_arr[i][k] = distance;
                    } else {
                        int bottom = matrix[i + 1][k];
                        int right = matrix[i][k + 1];
                        distance = Math.min(Math.abs(matrix[i][k] - bottom) + right_arr[i + 1][k], Math.abs(matrix[i][k] - right) + right_arr[i][k + 1]);
                        right_arr[i][k] = distance;
                    }
                }
                if (right_map.containsKey(matrix[i][k])) {
                    right_map.put(matrix[i][k], Math.min(right_map.get(matrix[i][k]), distance));
                } else {
                    right_map.put(matrix[i][k], distance);
                }

            }
        }

        //相加取最小
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : left_map.entrySet()) {
            res = Math.min(res, left_map.get(entry.getKey()) + right_map.get(entry.getKey()));
        }

        System.out.println(res);
    }


}
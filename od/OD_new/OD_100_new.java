package com.od.OD.OD130;

import java.util.Scanner;
/*
*信号发射和接收
*
*
* */

class OD_100_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int row_count = in.nextInt();
        int col_count = in.nextInt();

        int[][] anth = new int[row_count][col_count];
        for (int i = 0; i < row_count; i++) {
            for (int j = 0; j < col_count; j++) {
                anth[i][j] = in.nextInt();
            }
        }

        //遍历每一个天线
        String res = "";
        for (int i = 0; i < row_count; i++) {
            for (int j = 0; j < col_count; j++) {
                int count = south(anth, i, j) + east(anth, i, j);
                if (i == row_count - 1 && j == col_count - 1) {
                    res += count;
                } else {
                    res += count + " ";
                }

            }
        }

        // 输出
        System.out.println(row_count + " " + col_count);
        System.out.println(res);
    }

    //东向判断,其实是以当前天线向西遍历判断
    public static int east(int[][] anth, int i, int j) {
        //第0根天线肯定无法接收信号
        if (j == 0) return 0;

        int max_height = anth[i][j - 1];
        // 当前天线的西侧第一根天线必然可以接收
        int count = 1;

        for (int k = j - 2; k >= 0; k--) {
            if (max_height >= anth[i][j]) {
                break;
            }
            if (anth[i][k] > max_height) {
                count++;
                max_height = anth[i][k];
            }
        }

        return count;
    }

    //南向判定，其实是以当前天线向北遍历判断
    public static int south(int[][] anth, int i, int j) {
        //第0根天线肯定无法接收信号
        if (i == 0) return 0;

        int max_height = anth[i - 1][j];
        // 当前天线的北侧第一根天线必然可以接收
        int count = 1;

        for (int k = i - 2; k >= 0; k--) {
            if (max_height >= anth[i][j]) {
                break;
            }
            if (anth[k][j] > max_height) {
                count++;
                max_height = anth[k][j];
            }
        }

        return count;
    }

}
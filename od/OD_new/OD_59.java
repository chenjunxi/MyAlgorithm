package com.od.OD.OD130;

import java.util.Scanner;

//消消乐
//岛屿数量问题和OD有点类型
//思路：构造二维数组，循环二维数组，写感染函数
public class OD_59 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] strings = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j] == 1) {
                    infect(dp, i, j, N, M);
                    count++;
                }
            }

        }
        //打印
        System.out.println("次数：" + count);


    }

    public static void infect(int[][] arr, int i, int j, int N, int M) {
        //边界问题
        if (i < 0 || i > N - 1 || j < 0 || j > M - 1 || arr[i][j] == 0) {
            return;
        }

        arr[i][j] = 0;
        infect(arr, i, j - 1, N, M); //上
        infect(arr, i - 1, j, N, M); //左
        infect(arr, i, j + 1, N, M);//右
        infect(arr, i + 1, j, N, M); //下
        infect(arr, i - 1, j - 1, N, M);//左上
        infect(arr, i + 1, j - 1, N, M);//左下
        infect(arr, i + 1, j + 1, N, M);//右下
        infect(arr, i - 1, j + 1, N, M);//右上

    }
}

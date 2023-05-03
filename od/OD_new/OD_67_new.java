package com.od.OD.OD130;

import java.util.Scanner;

/*
* 基站维护最短距离
* */
class OD_67_new {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        //转为数组
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println(solve(n, matrix));
    }

    public static int solve(int n, int[][] matrix) {
        int MAX=1<<n;
        int[][] dp = new int[n][1<<n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<(1<<n);j++) {
                dp[i][j]=n*500;
            }
        }
        for(int i=0;i<n;i++) {
            dp[i][1<<i]=matrix[0][i];
        }

        //j为当前状态
        for(int j=0;j<MAX;j++) {
            //i为当前基站
            for(int i=0;i<n;i++) {
                if((j&(1<<i))==0) {
                    continue;
                }  //注意运算符优先级
                //k为下一个基站
                for(int k=0;k<n;k++) {
                    dp[i][j]=Math.min(dp[i][j], dp[k][j&(~(1<<i))]+matrix[k][i]);
                }
            }
        }
        return dp[0][MAX-1];
    }

}
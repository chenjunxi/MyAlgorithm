package com.od.OD.OD130;

import java.util.Scanner;
/*
* 查找充电设备组合
* */
public class OD_86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []p = new int[n];
        for(int i=0;i<n;i++) {
            p[i] = in.nextInt();
        }

        int max = in.nextInt();
        System.out.println(result(n,p,max));
    }

    public static int result(int n,int[]p,int max) {
        int[][]dp = new int[n+1][max+1];
        for(int i= 0;i<=n;i++) {
            for(int j=0;j<=max;j++) {
                if(i==0||j==0) {
                    continue;
                }
                if(p[i-1]>j) {
                    dp[i][j] =dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],p[i-1]+dp[i-1][j-p[i-1]]);
                }
            }
        }
        return dp[n][max];
    }
}
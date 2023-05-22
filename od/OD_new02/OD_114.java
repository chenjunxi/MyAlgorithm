package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
/*
* 大炮攻城 求最大伤害
3 100 20  3种大炮 100个火药 攻城总时间
10 8 5   威力10 损耗8个火药 装火药需要时间5
5 2 1
20 25 8

* */
public class OD_114 {
    public static int min_num;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int t = in.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            B[i] = in.nextInt();
            C[i] = in.nextInt();

        }

        int[] dp = new int[m+1];
        for (int i=0;i<n;i++) {
            for (int j=m-1;j>=0;j--) {
                // t//C[i] 表示当前大炮最多可以攻击的次数，也对应了物品的个数
                int count = Math.min((m-j)/B[i], t/C[i]);
                for (int k=1;k<count+1;k++){
                    dp[j+k*B[i]] = Math.max(dp[j+k*B[i]], dp[j]+k*A[i]);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[m]);
        return;
    }
}
package com.od.OD.OD130;

import java.util.*;
import java.util.stream.Collectors;
/*
* 核酸检测人员安排
*
* */
class OD_72 {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int sample_num = in.nextInt();
        int volunteer_num = in.nextInt();

        Integer[] efficiencys = new Integer[sample_num];
        for (int i = 0; i < sample_num; i++) {
            efficiencys[i] = in.nextInt();
        }

        int[] range_efficiencys = new int[sample_num];
        for (int i = 0; i < sample_num; i++) {
            range_efficiencys[i] = efficiencys[i]/10;
        }
        int[][] dp = new int[sample_num+1][volunteer_num+1];
        int count = 0;
        for (int i = 1; i < sample_num+1; i++) {
            count += (efficiencys[i-1] - 2*range_efficiencys[i-1]);
            dp[i][0] = count;
        }

        for (int i = 1; i < sample_num+1; i++) {
            for (int j = 1; j < volunteer_num+1; j++) {
                dp[i][j] = Math.max( dp[i-1][j]+efficiencys[i-1]-2*range_efficiencys[i-1], dp[i-1][j-1]+efficiencys[i-1]);     //志愿者大于等于1
                dp[i][j] = Math.max( dp[i][j], j-2 >= 0 ? dp[i-1][j-2]+efficiencys[i-1]+range_efficiencys[i-1] : 0);    //志愿者大于等于2
                dp[i][j] = Math.max( dp[i][j], j-3 >= 0 ? dp[i-1][j-3]+efficiencys[i-1]+2*range_efficiencys[i-1] : 0);  //志愿者大于等于3
                dp[i][j] = Math.max( dp[i][j], j-4 >= 0 ? dp[i-1][j-4]+efficiencys[i-1]+3*range_efficiencys[i-1] : 0);  //志愿者大于等于4
            }
        }

        System.out.println(dp[sample_num][volunteer_num]);
    }

}
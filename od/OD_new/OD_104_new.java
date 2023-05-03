package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
* 日志限流
* */
public class OD_104_new {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        int[] records = new int[N];
        long single_total = 0;
        for (int i = 0; i < N; i++) {
            records[i] = in.nextInt();
            single_total += records[i];
        }
        int total = in.nextInt();

        // 一天产生的日志总条数小于等于total
        if(single_total <= total) {
            System.out.println(-1);
            return;
        } else {
            Arrays.sort(records);

            //二分法初始化
            int left = total / N;
            int right = records[N - 1];

            int result = left;
            while (right > left+1) {
                int mid = (right + left) / 2;

                int temp_total = 0;
                for (int i=0; i<N; i++){
                    temp_total += Math.min(records[i], mid);
                }

                if (temp_total > total) {
                    right = mid;
                } else if (temp_total < total) {
                    left = mid;
                    result = mid;
                } else {
                    System.out.println(mid);
                    return;
                }
            }

            System.out.println(result);
            return;
        }

    }


}
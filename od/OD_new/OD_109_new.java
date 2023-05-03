package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
*实力差距最小总和
*
* */
class OD_109_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 处理输入
        int n = in.nextInt();
        int d = in.nextInt();
        int[] data = new int[n];
        for(int i = 0;i<n;i++){
            data[i] = in.nextInt();
        }
        // 按照大小排序
        Arrays.sort(data);

        //pair个数
        int[] dp1 = new int[n+1];
        //最小和
        int[] dp2 = new int[n+1];

        for (int i=2;i<n+1;i++){
            int tmp = 0;
            if (data[i-1] - data[i-2] <= d)
                tmp += 1;

            if (dp1[i-2]+tmp>dp1[i-1]){
                dp1[i] = dp1[i-2] + tmp;
                dp2[i] = dp2[i-2] + data[i-1] - data[i-2];
            }
            else if (dp1[i-2]+tmp<dp1[i-1]){
                dp1[i] = dp1[i-1];
                dp2[i] = dp2[i-1];
            }
            else{
                if (tmp == 1)
                    dp2[i] = Math.min(dp2[i-1], dp2[i-2]+data[i-1]-data[i-2]);
                else
                    dp2[i] = Math.min(dp2[i-1], dp2[i-2]);
                dp1[i] = dp1[i-1];
            }
        }

        if (dp1[n] == 0)
            System.out.println(-1);
        else
            System.out.println(dp2[n]);

    }


}
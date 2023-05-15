package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 最大化控制资源成本/任务混部
3
2 3 1 第一个任务在时间区间[2,3)运行 占用1个服务器
6 9 2
0 5 1
输出2
就是求所有任务启动时间时所需最大的服务器数量
2
3 9 2
4 7 3
输出 5
* */
public class OD_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int taskNum = sc.nextInt();
        int[] serversMap = new int[50000];
        for (int i = 0; i < taskNum; i++) {

            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            int parallelism = sc.nextInt();
            serversMap[startTime] += parallelism;
            serversMap[endTime] -= parallelism;
        }
        //每个时间所需要的服务器个数
        //starttime：加上所需服务器
        //endtime：减去所需服务器


        int totalServerNum = 0;
        int res = 0;
        for (int i = 0; i < serversMap.length; i++) {
            totalServerNum += serversMap[i];    //任务开始加，任务结束减
            res = Math.max(res, totalServerNum);
        }

        System.out.println(res);

    }
}

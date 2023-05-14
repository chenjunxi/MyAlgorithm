package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 最大化控制资源成本/任务混部
3
2 3 1 第一个任务在[2,3)运行 占用1个服务器
6 9 2
0 5 1
输出2
* */
public class OD_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int taskNum = sc.nextInt();

        List<Task> list = new ArrayList<>();
        for(int i=0; i<taskNum; i++){
            Task task = new Task( sc.nextInt(), sc.nextInt(), sc.nextInt());
            list.add(task);
        }
        //每个时间所需要的服务器个数
        //starttime：加上所需服务器
        //endtime：减去所需服务器
        int[] serversMap = new int[50000];

        for (Task task : list) {
            serversMap[task.startTime] += task.parallelism;
            serversMap[task.endTime] -= task.parallelism;
        }

        int totalServerNum = 0;
        int res = 0;
        for (int i = 0; i < serversMap.length; i++) {
            totalServerNum += serversMap[i];    //任务开始加，任务结束减
            res = Math.max(res, totalServerNum);
        }

        System.out.println(res);

    }

    public static class Task{

        public int startTime;

        public int endTime;

        public int parallelism;

        public Task(int sT, int eT, int para) {

            this.startTime = sT;
            this.endTime = eT;
            this.parallelism = para;

        }
    }

}

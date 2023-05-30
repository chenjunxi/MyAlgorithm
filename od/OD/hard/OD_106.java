package com.od.OD.bei;

import java.util.Arrays;
import java.util.Scanner;
/*
*工单调度策略
每个任务需要一个小时完成，规定时间内完成就有积分，思路就优选最大积分的
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1
输出15
第一个小时选1 7
第二个小时选2 5
第三个小时选3 2
第四个小时选6 1
3
1 7
2 8
2 9
输出17
* */
public class OD_106 {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[][] tasks = new int[n][2];
        for(int i = 0;i<n;i++){
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
        }

        // 按照积分大小先排序
        Arrays.sort(tasks, (a,b) -> b[1] - a[1]);
        /*for(int i = 0;i<n;i++){
            System.out.println(tasks[i][0]);
            System.out.println(tasks[i][1]);
        }*/

        // 每个SLA任务可获得的积分
        int[] maxScore = new int[70];
        for (int i = 0; i < tasks.length; i++) {
            //如果当前这个SLA任务为0, 那么优先处理最大积分
            if (maxScore[tasks[i][0]] == 0) {
                maxScore[tasks[i][0]] = tasks[i][1];
            } else {
                // SLA 减去 工单处理耗时1小时 得到下一个SLA
                int t = tasks[i][0] - 1;
                //查看下一个SLA有没有被赋值过
                while (t > 0 && maxScore[t] != 0) {
                    t--;
                }
                //若找到下一个SLA没有被赋值过的，可以直接处理当前工单
                if (t > 0) {
                    maxScore[t] = tasks[i][1];
                }
            }
        }
        int res = 0;
        for (int score:maxScore) {
            res += score;
        }
        System.out.println(res);
    }


}
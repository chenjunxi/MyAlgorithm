package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
/*快速开租建站 leetcode210
拓扑排序 就是先去取出没箭头的项(即入度=0)加入排序，然后再取没箭头的项
求所有建站完成最少时间
5
3 表示3个依赖任务
0 3 3任务依赖0任务 0->3
0 4
1 3
输出2 第0、1 、2同时部署，因为他们入度为0;再同时部署3 和4 ，所以共花2个时间
其实就是统计一共发生了几次入度为0

* */

class OD_81 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int taskNum = in.nextInt();
        int relationsNum = in.nextInt();

        int[][] relation_ids = new int[relationsNum][2];
        for (int i = 0; i < relationsNum; i++) {
            relation_ids[i][0] = in.nextInt();
            relation_ids[i][1] = in.nextInt();
        }

        // 每个任务的前置依赖任务个数，也就是拓扑排序中的入度
        int[] upstream = new int[taskNum];
        // 每个任务的下游任务， 也就是拓扑排序中的出度
        List<List<Integer>> downstream =new ArrayList<List<Integer>>(taskNum);
        for (int i=0;i<taskNum;i++) {
            downstream.add(new ArrayList<>());
        }

        //初始化入度、出度
        for (int[] relation_id : relation_ids) {
            downstream.get(relation_id[0]).add(relation_id[1]);
            upstream[relation_id[1]]+=1;
        }

        //队列中保存当前入度为0 的任务id
        LinkedList<Integer[]> queue = new LinkedList<>();
        int result = 1;

        for (int i = 0; i < taskNum; i++) {
            //将所有入度为零的任务入队, 默认耗时为1
            if (upstream[i] == 0) {
                queue.add(new Integer[] {i, result});
            }
        }

        while (queue.size() > 0) {
            Integer[] current_task = queue.removeFirst();
            int task = current_task[0];
            int time = current_task[1];

            for (Integer downstream_task : downstream.get(task)) {
                // 当前任务的入度减小到0时，放入queue中
                if (--upstream[downstream_task] == 0) {
                    result = time + 1;
                    queue.add(new Integer[] {downstream_task, result});
                }
            }

        }

        System.out.println(result);

    }

}
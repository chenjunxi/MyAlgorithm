package com.od.OD.bei;

import java.util.*;

//单核CPU调度
//知识点队列优先级队列，保证
public class OD_53 {


    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        LinkedList<Long[]> tasks = new LinkedList<>();
        while (in.hasNextLine()) {
            tasks.add(Arrays.stream(in.nextLine().split(" ")).map(Long::parseLong).toArray(Long[]::new));
        }

        // 优先级队列　－＞　最大堆
        PriorityQueue<Long[]> task_queue = new PriorityQueue<>((a, b) -> (int) (b[1] - a[1]));
        task_queue.offer(tasks.removeFirst());

        Long cur_time = (long) 0;
        //保存所有执行结束的任务信息
        ArrayList<Long[]> result = new ArrayList<>();

        while (tasks.size() > 0) {
            // 取最大堆的堆顶，task中元素分别为[任务ID,任务优先级,执行时间,到达时间]
            Long[] task1 = task_queue.peek();
            Long[] task2 = tasks.removeFirst();

            // 第一个任务结束时间
            Long stop_time = task1[2] + task1[3];

            // 当前任务可以执行完，不用暂停让高优先级的去跑
            if (task2[3] >= stop_time) {
                result.add(new Long[]{task1[0], stop_time});
                task_queue.poll();

                // 下一个任务在第一个任务执行完之后隔一段时间才能到
                if (task2[3] > stop_time) {
                    Long gap_time = task2[3] - stop_time;

                    // 继续取出高优先级的去跑
                    while (task_queue.size() > 0) {
                        Long[] task3 = task_queue.peek();

                        // 如果下一个任务执行时长，小于CPU空闲时长的话，可以先跑
                        if (task3[2] <= gap_time) {
                            stop_time += task3[2];
                            gap_time -= task3[2];
                            result.add(new Long[]{task3[0], stop_time});
                            task_queue.poll();
                        } else {
                            task3[2] -= gap_time;
                            break;
                        }
                    }
                }
            }
            // 需要暂停当前任务，让到来的高优先级先跑
            else {
                task1[2] -= task2[3] - task1[3];
            }
            cur_time = task2[3];
            task_queue.offer(task2);
        }

        // 之后的任务，因为已经按照优先级排完序，依次执行
        while (task_queue.size() > 0) {
            Long[] cur_task = task_queue.poll();

            cur_time += cur_task[2];
            result.add(new Long[] {cur_task[0], cur_time});
        }

        result.forEach(task -> System.out.println(task[0] + " " + task[1]));
    }
}
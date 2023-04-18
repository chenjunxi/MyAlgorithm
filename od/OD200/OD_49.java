package com.od.OD.OD200;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//单核CPU调度
//知识点队列优先级队列，保证
public class OD_49 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] strings = sc.nextLine().split(" ");
            list.add(new Task(strings));
        }

        PriorityQueue<Task> queue = new PriorityQueue<>();

        long time = 0;
        for (Task task : list) {
            long h = task.starTime - time;

            while (!queue.isEmpty() && h > 0) {

                if (queue.peek().excTime <= h) {
                    Task temp = queue.poll();
                    h = h - temp.excTime;
                    time = time + temp.excTime;
                    System.out.println(temp.id + " " + time);
                } else {
                    Task temp = queue.peek();
                    temp.excTime = temp.excTime - h;
                    time = time + h;
                    break;
                }

            }
            if (task.starTime > time) {
                time = task.starTime;
            }

            queue.add(task);

        }

        while (!queue.isEmpty()) {
            Task temp = queue.poll();
            time = time + temp.excTime;
            System.out.println(temp.id + " " + time);
        }

    }


    static class Task implements Comparable<Task> {

        public String id;
        public long pro;
        public long excTime;
        public long starTime;

        public Task(String[] str) {
            this.id = str[0];
            this.pro = Long.parseLong(str[1]);
            this.excTime = Long.parseLong(str[2]);
            this.starTime = Long.parseLong(str[3]);
        }


        @Override
        public int compareTo(Task o) {

            if (this.pro == o.pro) {
                return (int) (this.pro - o.pro);
            }

            return (int) (o.pro - this.pro);
        }
    }
}

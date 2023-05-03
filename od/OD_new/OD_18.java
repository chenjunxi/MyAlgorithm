package com.od.OD.OD130;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

//打印文件，利用PriorityQueue，加上自定义排序，每次poll元素就是优先级最高的。
/*
------------------
7
IN 1 1
IN 1 2
IN 1 3
IN 2 1
OUT 1
OUT 2
OUT 2
------------------
5
IN 1 1
IN 1 3
IN 1 1
IN 1 3
OUT 1
*
*
* */
public class OD_18 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

//        sc.nextLine(); 数字输入转字符串输入就需求这句

        HashMap<String, PriorityQueue<int[]>> map = new HashMap<>();

        int num = 0;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");

            String type = input[0];
            String key = input[1];
            if (type.equals("IN")) {
                num++;
                if (map.containsKey(key)) {
                    PriorityQueue<int[]> queueOld = map.get(key);
                    queueOld.add(new int[]{Integer.parseInt(input[2]), num});
                } else {

                    //数组第一位存放权重值，第二位存放编号
                    PriorityQueue<int[]> queue = new PriorityQueue<>((f1, f2) -> {
                        if (f1[0] == f2[0]) return f1[1] - f2[1];
                        return f2[0] - f1[0];
                    });

                    queue.add(new int[]{Integer.parseInt(input[2]), num});
                    map.put(key, queue);
                }
            } else if (type.equals("OUT")) {

                if (map.containsKey(key)) {
                    PriorityQueue<int[]> queuePoll = map.get(key);

                    if (!queuePoll.isEmpty()) {
                        System.out.println(queuePoll.poll()[1]);
                    } else {
                        System.out.println("NULL");  //队列没有文件的时候
                    }

                } else {
                    System.out.println("NULL");
                }
            }
        }
    }


}

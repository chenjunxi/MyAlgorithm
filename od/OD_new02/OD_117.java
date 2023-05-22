package com.od.OD.OD130;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
 *银行插队
 和文件打印题一样，使用优先队列加上自定义排序。
4
a 1 3
a 2 2
a 3 2
p

 * */
public class OD_117 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {

            String[] input = in.nextLine().split(" ");

            String type = input[0];
            if (type.equals("a")) {
                queue.add(new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
            } else if (type.equals("q")) {
                System.out.println(queue.poll()[0]);
            }
        }
    }

}
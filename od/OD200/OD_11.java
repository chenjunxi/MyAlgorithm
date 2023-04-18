package com.od.OD.OD200;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/*
滑窗中的单调队列：

* */
public class OD_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String[] split = sc.nextLine().split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        //边界情况
        if (k >= ints.length) {
            System.out.println(Arrays.stream(ints).min().getAsInt());
            return;
        }

        for (int i = 0; i < ints.length; i++) {

            //超出滑窗边界的时候
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.pop();
            }

            //每次进队列的数都要小于队列最后一个元素，否则就弹出最后一个元素
            while (!queue.isEmpty() && ints[queue.peekLast()] > ints[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            if (i >= k - 1) {
                builder.append(ints[queue.peek()]).append(",");
            }
        }
        String res = builder.toString();
        System.out.println(res.substring(0, res.length() - 1));
    }
}

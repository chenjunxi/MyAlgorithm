package com.od.OD.OD130;

import org.apache.flink.table.expressions.In;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 投篮大赛
逻辑题
+表示前面两次分数相加
D表示得分为前一次的2倍
C表示本次得分为0，并且把前一次得分也为0

数字正常加
* */
public class OD_60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ops = sc.nextLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (ops.equals("+")) {
                int size = list.size();
                if (size < 2) {
                    flag = true;
                    break;
                }
                list.add(list.get(size - 1) + list.get(size - 2));
            } else if (op.equals("C")) {
                int size = list.size();
                if (size == 0) {
                    flag = true;
                    break;
                }
                list.remove(size - 1);
            } else if (op.equals("D")) {
                int size = list.size();
                if (size == 0) {
                    flag = true;
                    break;
                }
                list.add(list.get(size - 1) * 2);
            } else {
                list.add(Integer.parseInt(op));
            }
        }
    }
}

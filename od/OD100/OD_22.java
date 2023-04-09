package com.od.OD.OD100;

import org.apache.flink.table.expressions.In;

import java.util.ArrayList;
import java.util.Scanner;

public class OD_22 {
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

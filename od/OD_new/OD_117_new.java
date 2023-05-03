package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
*银行插队
* */
public class OD_117_new{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < 6; i++){
            List<Integer> b = new ArrayList<>();
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String op;
            op = in.next();
            if (op.equals("a")) {
                int x, y;
                x = in.nextInt();
                y = in.nextInt();
                a.get(y).add(x);
            } else {
                for (int j = 1; j <= 5; j++) {
                    if (a.get(j).size()!=0) {
                        System.out.println(a.get(j).remove(0));
                        break;
                    }
                }
            }
        }
    }

}
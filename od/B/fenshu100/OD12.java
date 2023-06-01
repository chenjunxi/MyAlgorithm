package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OD12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        List<Integer> list1 = new ArrayList<>();  //一班
        List<Integer> list2 = new ArrayList<>();  //二班

        boolean b = true;   //用来转换班级 true为一班 false为二班
        boolean isError = false;

        for (int i = 0; i < strings.length; i++) {
            String[] x = strings[i].split("/");
            if (!Character.isDigit(x[0].charAt(0))) {    //第一个非数字
                isError = true;
                break;
            }
            Integer stu = Integer.valueOf(x[0]);
            if ((!x[1].equals("N") && !x[1].equals("Y"))
                    || list1.contains(stu)
                    || list2.contains(stu)) {
                isError = true;
                break;
            }
            if (list1.size() == 0) {    //第一位直接安排一班
                list1.add(stu);
                continue;
            }
            if (b) {  //此时是一班
                if (x[1].equals("N")) {
                    list2.add(stu);   //非一班
                    b = false;
                } else {
                    list1.add(stu);
                }
            } else {    //此时是二班
                if (x[1].equals("N")) {
                    list1.add(stu);   //非二班
                    b = true;
                } else {
                    list2.add(stu);
                }
            }

        }

        if (isError) {
            System.out.println("ERROR");
        } else {
            Collections.sort(list1);
            Collections.sort(list2);
            String res1 = "";
            String res2 = "";
            for (int i = 0; i < list1.size(); i++) {
                res1 += list1.get(i) + " ";
            }
            for (int i = 0; i < list2.size(); i++) {
                res2 += list2.get(i) + " ";
            }
            if (list2.size() == 0) {
                System.out.println(res1.substring(0, res1.length() - 1));
                System.out.println();
            } else if (list1.get(0) < list2.get(0)) {
                System.out.println(res1.substring(0, res1.length() - 1));
                System.out.println(res2.substring(0, res2.length() - 1));
            } else {
                System.out.println(res2.substring(0, res2.length() - 1));
                System.out.println(res1.substring(0, res1.length() - 1));
            }
        }
    }
}

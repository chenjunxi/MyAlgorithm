package com.od.OD.OD200;

import java.util.ArrayList;
import java.util.Scanner;

//去除多余的空格，但是不处理''内的多余空格
public class OD_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] zuobiao = sc.nextLine().split(",");


        String res = "";
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '\'') {
                flag = !flag; //判断是否在单引号内
            }
            if (flag) {
                if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') {
                    list.add(i);
                    continue; //相当于不添加第一个空格
                }
            }

            res += str.charAt(i);
        }

        res += str.charAt(str.length() - 1);
        System.out.println(res);
        System.out.println(list);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();

        for (String index : zuobiao) {
            String[] s = index.split(" ");
            ArrayList<Integer> temp = new ArrayList<>();

            int value1 = Integer.parseInt(s[0]);
            int value2 = Integer.parseInt(s[1]);
            int count = fun(list, value1);
            temp.add(value1 - count);
            temp.add(value2 - count);
            resList.add(temp);

        }

        System.out.println(resList);

    }

    private static int fun(ArrayList<Integer> list, int value) {

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int integer = list.get(i);
            if (integer < value) {
                count++;
            }
        }

        return count;
    }
}

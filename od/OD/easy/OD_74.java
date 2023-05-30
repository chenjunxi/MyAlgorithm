package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
最大数字
原理就是：任意删除一位，只要删除其比后面小的时候
* 这个题从前往后遍历，如果数字数量达到3，则看前面两个数字，
* 先看第一个，如果这个数字后面的数字比他大，就删这个，
* 否则看第二个，如果第二个后面的数字比他大，就删第二个，否则删刚遇到的这个
* */
public class OD_74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        List<Integer> list = new ArrayList<>();
        int[] record = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - '0';
            if (record[a] < 2) {
                list.add(a);
                record[a]++;
            } else {
                int index1 = list.indexOf(a);
                int index2 = list.lastIndexOf(a);
                if (list.get(index1 + 1) > list.get(index1)) {
                    list.remove(index1);
                    list.add(a);
                    continue;
                }
                if (index2 < list.size() - 1 && list.get(index2 + 1) > list.get(index2)) {
                    list.remove(index2);
                    list.add(a);
                    continue;
                }
            }
        }
        System.out.println(list);
    }
}

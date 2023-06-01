package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int n = scanner.nextInt();

        int max = 0;
        int length = 0;
        List<Integer> list = new ArrayList<>();     //用列表存放符合要求的数

        list.add(Math.abs(s1.charAt(0) - s2.charAt(0)));      //假设第一个字母就符合要求
        int count = list.get(0);        //第一个字母ASCII码之差的绝对值

        for (int i = 1; i < s1.length(); i++) {

            int temp = Math.abs(s1.charAt(i) - s2.charAt(i));

            list.add(temp);     //直接将本次的ASCII码之差的绝对值添加进列表
            count += Math.abs(temp);      //求最新的绝对值和

            if (count <= n) {
                length = list.size();       //若符合要求则最长的为列表的长度
            } else {
                count -= list.get(0);   //不符合则减去并删除列表第一个数
                list.remove(0);
            }
            max = Math.max(length, max);
        }

        System.out.println(max);
    }
}

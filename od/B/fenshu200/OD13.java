package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        //前缀
        String prefix = strings[0];
        //单词个数
        int n = Integer.valueOf(strings[1]);
        //前缀长度
        int len = prefix.length();
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //单词
            String str = strings[i + 2];
            if (str.length() >= len && str.startsWith(prefix)) {
                //首先判断长度是否大于等于前缀，同时是否以前缀开始
                resList.add(str);
            }
        }

        if (resList.size() == 0) {
            System.out.println(-1);
        } else {
            for (String s : resList) {
                System.out.println(s);
            }
        }
    }
}

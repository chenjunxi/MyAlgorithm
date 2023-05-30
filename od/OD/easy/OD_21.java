package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/*
* 二元组个数
若a[i]==b[i],则称[i,j]为一个二元组
求给定两个数组中统计二元组个数
4 第一个数组个数
1 2 3 4 第一个数组的元素
1 第二个数组个数
1 第二个数组元素
输出1

* */
public class OD_21 {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        //创建hash结构
        HashMap<Integer, Integer> m_info = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            if (m_info.containsKey(num)) {
                m_info.put(num, m_info.get(num) + 1);
            } else {
                m_info.put(num, 1);
            }
        }

        int n = in.nextInt();

        HashMap<Integer, Integer> n_info = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (n_info.containsKey(num)) {
                n_info.put(num, n_info.get(num) + 1);
            } else {
                n_info.put(num, 1);
            }
        }

        //算对数
        long result = 0;
        for (Map.Entry<Integer, Integer> x : m_info.entrySet()) {
            if (n_info.containsKey(x.getKey())) {
                result += x.getValue() * n_info.get(x.getKey());
            }
        }
        System.out.println(result);


    }
}
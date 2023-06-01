package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class OD12 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] ints = new int[m][m];
        for (int i = 0; i < m; i++) {
            ints[i][i] = 1;     //二阶数组，i=j相当于自己跟自己连接
        }

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt() - 1;    //因为数组是从0开始的所以要-1
            int c = sc.nextInt() - 1;
            ints[r][c] = 1;     //二阶数组中值等于1相当于i与j相连
            ints[c][r] = 1;
        }

        int fs = sc.nextInt();
        int count = 0;  //fs节点广播所有节点所需长度
        HashSet<Integer> hashSet = new HashSet<>(); //已经广播到的节点数组
        List<Integer> temp = new ArrayList<>();     //上次广播到的节点
        temp.add(fs - 1); //因为数组是从0开始的所以要-1
        hashSet.add(fs - 1);
        while (hashSet.size() < m) {

            List<Integer> list = new ArrayList<>(temp); //上次广播到的节点进入本次广播
            temp.clear();
            for (int j = 0; j < list.size(); j++) {
                int index = list.get(j);    //当前广播节点
                for (int i = 0; i < m; i++) {
                    if (!hashSet.contains(i) && index != j && ints[index][i] == 1) {  //将index能广播的节点添加到set、temp数组中
                        hashSet.add(i); //已经广播到的节点数组
                        temp.add(i);
                    }
                }
                if (hashSet.size() == m) {  //标识所有节点都已经广播到了
                    break;
                }
            }
            count++;
        }

        System.out.println(count * 2);
    }
}

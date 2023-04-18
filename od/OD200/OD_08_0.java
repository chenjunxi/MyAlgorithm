package com.od.OD.OD200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//回溯算法
public class OD_08_0 {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] distance = new int[n][n];   //路程转化为二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < distance.length; i++) {
            List<Integer> points = new ArrayList<>();
            points.add(i);    //从基站2开始走
            dfs(distance, i, points, distance[0][i]);
        }

        System.out.println(min);
    }


    public static void dfs(int[][] ints, int index, List<Integer> points, int sum) {

        //结束条件
        if (points.size() == ints.length - 1) {
            min = Math.min(min, sum + ints[index][0]);     //记得加上基站1的路程
            return;
        }

        for (int i = 1; i < ints[index].length; i++) {
            if (i != index && points.contains(i)) {   //已经走过的基站不需要再走
                continue;
            }
            points.add(i);    //走过的基站
            sum += ints[index][i];
            dfs(ints, i, points, sum);    //index到达的基站，i下次去的基站
            points.remove(points.size() - 1);     //刚走过的基站需要剔除以便进行下一个循环
        }
    }
}

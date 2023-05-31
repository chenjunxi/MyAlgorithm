package com.od.OD.bei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 基站维护最短距离
 输入描述：

站点数n和各站点之间的距离（均为整数）。如：
3 {站点数}
0 2 1   {站点1到各站点的路程}
1 0 2  {站点2到各站点的路程}
2 1 0  {站点3到各站点的路程} 
 
输出描述：

3
 * */
class OD_67 {

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
            List<Integer> stepList = new ArrayList<>();
            stepList.add(i);    //从基站2开始走,因为刚刚开始(0,1)就是表示第二个基站的距离
            handle(distance, i, stepList, distance[0][i]);
        }

        System.out.println(min);
    }


    public static void handle(int[][] ints, int index, List<Integer> step, int sum) {

        //终止条件，因为不包括第一个基站，所以-1
        if (step.size()  == ints.length-1) {     //走完所有的基站，准备返回基站1
            min = Math.min(min, sum + ints[index][0]);     //记得加上基站1的路程
            return;
        }

        for (int i = 1; i < ints.length; i++) {
            if (step.contains(i)) {   //已经走过的基站不需要再走
                continue;
            }
            step.add(i);    //走过的基站
            handle(ints, i, step, sum + ints[index][i]);    //index到达的基站，i下次去的基站
            step.remove(step.size() - 1);     //刚走过的基站需要剔除以便进行下一个循环
        }

    }
}
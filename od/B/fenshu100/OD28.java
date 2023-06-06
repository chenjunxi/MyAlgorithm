package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

/*
* 五子棋
* 求能使当前给出的颜色最大连续长度的下标
1
-1 0 1 1 1 0 1 0 1 -1 1
输出5

-1
-1 0 1 1 1 0 1 0 1 -1 1
输出1

思路：求0的位置左右棋子的数量，哪个最多就填哪个
* */
public class OD28 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] L = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //最大连续棋子长度
        int max = Integer.MIN_VALUE;
        //到中间位置的距离
        int midDistance = 0;
        //最终下标
        int res = -1;
        for (int i = 0; i < L.length; i++) {

            if (L[i] == 0) {
                //左指针
                int left = i - 1;
                //右指针
                int right = i + 1;
                //左侧相同棋子的个数
                int totalLeft = 0;
                //右侧相同棋子的个数
                int totalRight = 0;
                //左侧棋子统计
                for (int j = left; j >= 0; j--) {
                    if (L[j] == n) {
                        totalLeft++;
                    } else {
                        break;
                    }
                }
                //右侧棋子统计
                for (int j = right; j < L.length; j++) {
                    if (L[j] == n) {
                        totalRight++;
                    } else {
                        break;
                    }
                }
                //两侧总共的棋子
                int total = totalLeft + totalRight;
                //题目要求不能赢
                if (total > 4) {
                    continue;
                }
                //坐标到中间位置距离
                int indexToMid = Math.abs(i - L.length / 2);
                if (total > max) {
                    //大于之前的最大值
                    max = total;
                    res = i;
                    midDistance = indexToMid;
                } else if (total == max && indexToMid < midDistance) {
                    //等于之前的最大值且距离中间位置较近
                    res = i;
                    midDistance = indexToMid;
                }
            }

        }

        System.out.println(res);
    }
}

package com.od.OD.bei;

import java.util.Arrays;
import java.util.Scanner;

/*
* 统计友好度最大值
1 1 0 1 2 1 0
* */
class OD_82 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] ints = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int[] dpLeft = new int[ints.length + 1];
        int[] dpRight = new int[ints.length + 1];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0 || ints[i] == 2) {
                dpLeft[i + 1] = 0;
            } else {
                dpLeft[i + 1] = dpLeft[i] + 1;
            }
        }

        for (int i = ints.length - 1; i >= 0; i--) {
            if (ints[i] == 0 || ints[i] == 2) {
                dpRight[i] = 0;
            } else {
                dpRight[i] = dpRight[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < ints.length; i++) {
            int a = dpLeft[i] + dpRight[i + 1];
            res = Math.max(a, res);
        }
        System.out.println(res);
    }

}
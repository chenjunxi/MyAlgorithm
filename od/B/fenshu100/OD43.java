package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

public class OD43 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //箱子上的数字数组。索引表示其编号
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        //咒语数
        int n = sc.nextInt();
        //是否找到箱子
        boolean flag = false;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            //左侧箱子
            int left = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                //右侧箱子
                int right = nums[j];
                if (left == right && j - i <= n) {
                    //两个箱子的数字相同且编号小于等于咒语数，符合要求
                    flag = true;
                    break;
                }
            }
            if (flag) {
                //找到了，记录左侧箱子的编号，并退出循环
                res = i;
                break;
            }
        }

        System.out.println(res);
    }
}

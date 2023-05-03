package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
/*
* 组装新的数组
*
* */
class OD_80_new {
    public static int m;
    public static int min_num;
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        m = in.nextInt();

        //排序找到最小值
        Arrays.sort(nums);
        min_num = nums[0];

        System.out.println(dfs(nums, 0, 0, 0));
    }

    public static int dfs(Integer[] nums, int index, int sum, int count) {
        if (sum > m) {
            return count;
        }

        //满足边界条件+1
        if (sum <= m && m - min_num < sum) {
            return count + 1;
        }

        for (int i = index; i < nums.length; i++) {
            count = dfs(nums, i, sum + nums[i], count);
        }

        return count;
    }

}
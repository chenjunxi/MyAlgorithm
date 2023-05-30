package com.od.OD.bei;

import java.util.Scanner;
import java.util.*;

/*
* 组装新的数组 数组组合的问题要熟悉一下
新组装的数组元素和等于M。求组装数量
2 3  表示2 到3的连续数组[2,3]
5 M值
输出2 [2,2,1] 和[2,3]

数组组合问题https://leetcode.cn/problems/combination-sum/solution/zu-he-zong-he-by-s1amduncan-prwk/
* */
class OD_80 {
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
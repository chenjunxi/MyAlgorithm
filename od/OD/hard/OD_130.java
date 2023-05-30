package com.od.OD.bei;

import java.util.Scanner;
import java.util.Stack;

/*
 * 天然货仓 100分 23.Q1 硬记
 * 参考：leetcode42 接雨水
2
4
0,-1,-2,0
输出：1
首先货物固定是1高度的，所以至少是-1才能装下
其次就要比较宽度，货物宽度为2，所以要有连续负数的坑才能装下，即-1 -2

3
5
0,-2,-2,-2,0

3
8
0,-1,-2,-1,-2,-1,-1,0

3
8
0,-1,-2,-2,-2,-1,-1,0
 * */
class OD_130 {
    public static void main(String[] args) {
        //输入处理
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        String[] str = in.nextLine().split(",");
        // 注意点: 因为可能数组两边为负数，所以要给定左右边界，左右多加一个0
        int[] nums = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(str[i - 1]);
        }

        if (len > n) {
            System.out.println(0);
            return;
        }
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当栈顶为负数，且当前遍历的元素比栈顶元素要大，此时要弹栈
            while (!stack.isEmpty() && nums[stack.peek()] < 0 && nums[i] > nums[stack.peek()]) {
                // 当前位置的索引和深度
                int index = stack.pop();
                int cur_depth = nums[index];
                if (stack.isEmpty())
                    break;
                int left_index = stack.peek(), left_depth = nums[left_index];
                // i - left_index - 1代表的是以cur_depth为下界，可以装下的最大宽度
                // (Math.min(left_depth, nums[i]) - cur_depth) 代表的是可以装几层，因为可能不只装一层
                int kuang = i - left_index - 1;
                int dept = Math.min(left_depth, nums[i]) - cur_depth;
                res += kuang / len * dept;
            }
            stack.push(i);
        }
        System.out.println(res);
    }
}
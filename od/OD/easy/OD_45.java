package com.od.OD.OD130;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
分奖金

* */
//单调栈写法
public class OD_45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            //遇到大于
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                nums[stack.peek()] = (nums[i] - nums[stack.peek()]) * (i - stack.peek());
                stack.pop();
            }
            stack.push(i);
        }

        //打印
        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[n - 1]);

    }

    private static void demo01(int n, int[] nums) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[j] > nums[i]) {
                    nums[i] = (nums[j] - nums[i]) * (j - i);
                    break;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[n - 1]);
    }
}
